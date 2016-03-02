package org.wso2.developerstudio.datamapper.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
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
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin;

/**
 * @generated
 */
public class DataMapperElementTypes {

	/**
	 * @generated
	 */
	private DataMapperElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			DataMapperDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType DataMapperRoot_1000 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.DataMapperRoot_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Input_2002 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Input_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Output_2003 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Output_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Equal_2005 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Equal_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Concat_2006 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Concat_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Split_2007 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Split_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constant_2008 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Constant_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LowerCase_2009 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.LowerCase_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Contains_2010 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Contains_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UpperCase_2011 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.UpperCase_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3002 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3003 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Attribute_3004 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Attribute_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3005 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3006 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Element_3007 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Element_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3008 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3009 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3011 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorBasicContainer_3012 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OperatorBasicContainer_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorLeftContainer_3013 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OperatorLeftContainer_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorLeftConnector_3014 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OperatorLeftConnector_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3015 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorRightContainer_3016 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OperatorRightContainer_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorRightConnector_3017 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OperatorRightConnector_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3018 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataMapperLink_4001 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.DataMapperLink_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(DataMapperRoot_1000, DataMapperPackage.eINSTANCE.getDataMapperRoot());

			elements.put(Input_2002, DataMapperPackage.eINSTANCE.getInput());

			elements.put(Output_2003, DataMapperPackage.eINSTANCE.getOutput());

			elements.put(Equal_2005, DataMapperPackage.eINSTANCE.getEqual());

			elements.put(Concat_2006, DataMapperPackage.eINSTANCE.getConcat());

			elements.put(Split_2007, DataMapperPackage.eINSTANCE.getSplit());

			elements.put(Constant_2008, DataMapperPackage.eINSTANCE.getConstant());

			elements.put(LowerCase_2009, DataMapperPackage.eINSTANCE.getLowerCase());

			elements.put(Contains_2010, DataMapperPackage.eINSTANCE.getContains());

			elements.put(UpperCase_2011, DataMapperPackage.eINSTANCE.getUpperCase());

			elements.put(TreeNode_3002, DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(TreeNode_3003, DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(Attribute_3004, DataMapperPackage.eINSTANCE.getAttribute());

			elements.put(InNode_3005, DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3006, DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(Element_3007, DataMapperPackage.eINSTANCE.getElement());

			elements.put(InNode_3008, DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3009, DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(TreeNode_3011, DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(OperatorBasicContainer_3012,
					DataMapperPackage.eINSTANCE.getOperatorBasicContainer());

			elements.put(OperatorLeftContainer_3013,
					DataMapperPackage.eINSTANCE.getOperatorLeftContainer());

			elements.put(OperatorLeftConnector_3014,
					DataMapperPackage.eINSTANCE.getOperatorLeftConnector());

			elements.put(InNode_3015, DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OperatorRightContainer_3016,
					DataMapperPackage.eINSTANCE.getOperatorRightContainer());

			elements.put(OperatorRightConnector_3017,
					DataMapperPackage.eINSTANCE.getOperatorRightConnector());

			elements.put(OutNode_3018, DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(DataMapperLink_4001, DataMapperPackage.eINSTANCE.getDataMapperLink());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(DataMapperRoot_1000);
			KNOWN_ELEMENT_TYPES.add(Input_2002);
			KNOWN_ELEMENT_TYPES.add(Output_2003);
			KNOWN_ELEMENT_TYPES.add(Equal_2005);
			KNOWN_ELEMENT_TYPES.add(Concat_2006);
			KNOWN_ELEMENT_TYPES.add(Split_2007);
			KNOWN_ELEMENT_TYPES.add(Constant_2008);
			KNOWN_ELEMENT_TYPES.add(LowerCase_2009);
			KNOWN_ELEMENT_TYPES.add(Contains_2010);
			KNOWN_ELEMENT_TYPES.add(UpperCase_2011);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3002);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3003);
			KNOWN_ELEMENT_TYPES.add(Attribute_3004);
			KNOWN_ELEMENT_TYPES.add(InNode_3005);
			KNOWN_ELEMENT_TYPES.add(OutNode_3006);
			KNOWN_ELEMENT_TYPES.add(Element_3007);
			KNOWN_ELEMENT_TYPES.add(InNode_3008);
			KNOWN_ELEMENT_TYPES.add(OutNode_3009);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3011);
			KNOWN_ELEMENT_TYPES.add(OperatorBasicContainer_3012);
			KNOWN_ELEMENT_TYPES.add(OperatorLeftContainer_3013);
			KNOWN_ELEMENT_TYPES.add(OperatorLeftConnector_3014);
			KNOWN_ELEMENT_TYPES.add(InNode_3015);
			KNOWN_ELEMENT_TYPES.add(OperatorRightContainer_3016);
			KNOWN_ELEMENT_TYPES.add(OperatorRightConnector_3017);
			KNOWN_ELEMENT_TYPES.add(OutNode_3018);
			KNOWN_ELEMENT_TYPES.add(DataMapperLink_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case DataMapperRootEditPart.VISUAL_ID:
			return DataMapperRoot_1000;
		case InputEditPart.VISUAL_ID:
			return Input_2002;
		case OutputEditPart.VISUAL_ID:
			return Output_2003;
		case EqualEditPart.VISUAL_ID:
			return Equal_2005;
		case ConcatEditPart.VISUAL_ID:
			return Concat_2006;
		case SplitEditPart.VISUAL_ID:
			return Split_2007;
		case ConstantEditPart.VISUAL_ID:
			return Constant_2008;
		case LowerCaseEditPart.VISUAL_ID:
			return LowerCase_2009;
		case ContainsEditPart.VISUAL_ID:
			return Contains_2010;
		case UpperCaseEditPart.VISUAL_ID:
			return UpperCase_2011;
		case TreeNodeEditPart.VISUAL_ID:
			return TreeNode_3002;
		case TreeNode2EditPart.VISUAL_ID:
			return TreeNode_3003;
		case AttributeEditPart.VISUAL_ID:
			return Attribute_3004;
		case InNodeEditPart.VISUAL_ID:
			return InNode_3005;
		case OutNodeEditPart.VISUAL_ID:
			return OutNode_3006;
		case ElementEditPart.VISUAL_ID:
			return Element_3007;
		case InNode2EditPart.VISUAL_ID:
			return InNode_3008;
		case OutNode2EditPart.VISUAL_ID:
			return OutNode_3009;
		case TreeNode3EditPart.VISUAL_ID:
			return TreeNode_3011;
		case OperatorBasicContainerEditPart.VISUAL_ID:
			return OperatorBasicContainer_3012;
		case OperatorLeftContainerEditPart.VISUAL_ID:
			return OperatorLeftContainer_3013;
		case OperatorLeftConnectorEditPart.VISUAL_ID:
			return OperatorLeftConnector_3014;
		case InNode3EditPart.VISUAL_ID:
			return InNode_3015;
		case OperatorRightContainerEditPart.VISUAL_ID:
			return OperatorRightContainer_3016;
		case OperatorRightConnectorEditPart.VISUAL_ID:
			return OperatorRightConnector_3017;
		case OutNode3EditPart.VISUAL_ID:
			return OutNode_3018;
		case DataMapperLinkEditPart.VISUAL_ID:
			return DataMapperLink_4001;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
