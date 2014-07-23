package org.wso2.developerstudio.datamapper.diagram.part;

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
import org.wso2.developerstudio.datamapper.Attribute;
import org.wso2.developerstudio.datamapper.Concat;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.Contains;
import org.wso2.developerstudio.datamapper.DataMapperLink;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.Equal;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.Input;
import org.wso2.developerstudio.datamapper.LowerCase;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.OperatorBasicContainer;
import org.wso2.developerstudio.datamapper.OperatorLeftConnector;
import org.wso2.developerstudio.datamapper.OperatorLeftContainer;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.OperatorRightContainer;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.Output;
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
import org.wso2.developerstudio.datamapper.diagram.edit.parts.UpperCaseEditPart;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes;

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
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006SemanticChildren(view);
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
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002SemanticChildren(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003SemanticChildren(view);
		case AttributeEditPart.VISUAL_ID:
			return getAttribute_3004SemanticChildren(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007SemanticChildren(view);
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
			if (visualID == ConcatEditPart.VISUAL_ID) {
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
	public static List<DataMapperNodeDescriptor> getTreeNode_3002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		TreeNode modelElement = (TreeNode) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it.hasNext();) {
			Attribute childElement = (Attribute) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AttributeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
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
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it.hasNext();) {
			Attribute childElement = (Attribute) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AttributeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getAttribute_3004SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Attribute modelElement = (Attribute) view.getElement();
		LinkedList<DataMapperNodeDescriptor> result = new LinkedList<DataMapperNodeDescriptor>();
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
		for (Iterator<?> it = modelElement.getNode().iterator(); it.hasNext();) {
			TreeNode childElement = (TreeNode) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == TreeNode2EditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getAttribute().iterator(); it.hasNext();) {
			Attribute childElement = (Attribute) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == AttributeEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getElement().iterator(); it.hasNext();) {
			Element childElement = (Element) it.next();
			int visualID = DataMapperVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementEditPart.VISUAL_ID) {
				result.add(new DataMapperNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperNodeDescriptor> getOperatorBasicContainer_3012SemanticChildren(
			View view) {
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
	public static List<DataMapperNodeDescriptor> getOperatorLeftContainer_3013SemanticChildren(
			View view) {
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
	public static List<DataMapperNodeDescriptor> getOperatorLeftConnector_3014SemanticChildren(
			View view) {
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
	public static List<DataMapperNodeDescriptor> getOperatorRightContainer_3016SemanticChildren(
			View view) {
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
	public static List<DataMapperNodeDescriptor> getOperatorRightConnector_3017SemanticChildren(
			View view) {
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
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006ContainedLinks(view);
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
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002ContainedLinks(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003ContainedLinks(view);
		case AttributeEditPart.VISUAL_ID:
			return getAttribute_3004ContainedLinks(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3005ContainedLinks(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006ContainedLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007ContainedLinks(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008ContainedLinks(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009ContainedLinks(view);
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
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006IncomingLinks(view);
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
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002IncomingLinks(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003IncomingLinks(view);
		case AttributeEditPart.VISUAL_ID:
			return getAttribute_3004IncomingLinks(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3005IncomingLinks(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006IncomingLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007IncomingLinks(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008IncomingLinks(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009IncomingLinks(view);
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
		case ConcatEditPart.VISUAL_ID:
			return getConcat_2006OutgoingLinks(view);
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
		case TreeNodeEditPart.VISUAL_ID:
			return getTreeNode_3002OutgoingLinks(view);
		case TreeNode2EditPart.VISUAL_ID:
			return getTreeNode_3003OutgoingLinks(view);
		case AttributeEditPart.VISUAL_ID:
			return getAttribute_3004OutgoingLinks(view);
		case InNodeEditPart.VISUAL_ID:
			return getInNode_3005OutgoingLinks(view);
		case OutNodeEditPart.VISUAL_ID:
			return getOutNode_3006OutgoingLinks(view);
		case ElementEditPart.VISUAL_ID:
			return getElement_3007OutgoingLinks(view);
		case InNode2EditPart.VISUAL_ID:
			return getInNode_3008OutgoingLinks(view);
		case OutNode2EditPart.VISUAL_ID:
			return getOutNode_3009OutgoingLinks(view);
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
	public static List<DataMapperLinkDescriptor> getConcat_2006ContainedLinks(View view) {
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
	public static List<DataMapperLinkDescriptor> getAttribute_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3006ContainedLinks(View view) {
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
	public static List<DataMapperLinkDescriptor> getOperatorBasicContainer_3012ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftContainer_3013ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftConnector_3014ContainedLinks(
			View view) {
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
	public static List<DataMapperLinkDescriptor> getOperatorRightContainer_3016ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightConnector_3017ContainedLinks(
			View view) {
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
	public static List<DataMapperLinkDescriptor> getConcat_2006IncomingLinks(View view) {
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
	public static List<DataMapperLinkDescriptor> getAttribute_3004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3005IncomingLinks(View view) {
		InNode modelElement = (InNode) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<DataMapperLinkDescriptor> result = new LinkedList<DataMapperLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3006IncomingLinks(View view) {
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
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement,
				crossReferences));
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
	public static List<DataMapperLinkDescriptor> getOperatorBasicContainer_3012IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftContainer_3013IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftConnector_3014IncomingLinks(
			View view) {
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
		result.addAll(getIncomingTypeModelFacetLinks_DataMapperLink_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightContainer_3016IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightConnector_3017IncomingLinks(
			View view) {
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
	public static List<DataMapperLinkDescriptor> getConcat_2006OutgoingLinks(View view) {
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
	public static List<DataMapperLinkDescriptor> getAttribute_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getInNode_3005OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOutNode_3006OutgoingLinks(View view) {
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
	public static List<DataMapperLinkDescriptor> getOperatorBasicContainer_3012OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftContainer_3013OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorLeftConnector_3014OutgoingLinks(
			View view) {
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
	public static List<DataMapperLinkDescriptor> getOperatorRightContainer_3016OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<DataMapperLinkDescriptor> getOperatorRightConnector_3017OutgoingLinks(
			View view) {
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
			if (DataMapperLinkEditPart.VISUAL_ID != DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InNode dst = link.getInNode();
			OutNode src = link.getOutNode();
			result.add(new DataMapperLinkDescriptor(src, dst, link,
					DataMapperElementTypes.DataMapperLink_4001, DataMapperLinkEditPart.VISUAL_ID));
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
			if (setting.getEStructuralFeature() != DataMapperPackage.eINSTANCE
					.getDataMapperLink_InNode()
					|| false == setting.getEObject() instanceof DataMapperLink) {
				continue;
			}
			DataMapperLink link = (DataMapperLink) setting.getEObject();
			if (DataMapperLinkEditPart.VISUAL_ID != DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			OutNode src = link.getOutNode();
			result.add(new DataMapperLinkDescriptor(src, target, link,
					DataMapperElementTypes.DataMapperLink_4001, DataMapperLinkEditPart.VISUAL_ID));
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
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
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
			if (DataMapperLinkEditPart.VISUAL_ID != DataMapperVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			InNode dst = link.getInNode();
			OutNode src = link.getOutNode();
			if (src != source) {
				continue;
			}
			result.add(new DataMapperLinkDescriptor(src, dst, link,
					DataMapperElementTypes.DataMapperLink_4001, DataMapperLinkEditPart.VISUAL_ID));
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
