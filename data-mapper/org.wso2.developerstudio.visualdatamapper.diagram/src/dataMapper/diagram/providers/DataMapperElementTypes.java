package dataMapper.diagram.providers;

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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

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
	private static ImageRegistry imageRegistry;

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
	public static final IElementType DataMapperDiagram_2001 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.DataMapperDiagram_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Input_3001 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Input_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3004 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3005 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Attribute_3006 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Attribute_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3009 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3010 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Element_3007 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Element_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3011 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3012 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Output_3002 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Output_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3008 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Concat_3013 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.Concat_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3014 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3015 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3016 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.InNode_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataMapperLink_4002 = getElementType("org.wso2.developerstudio.visualdatamapper.diagram.DataMapperLink_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return dataMapper.diagram.part.DataMapperDiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
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

			elements.put(DataMapperRoot_1000,
					dataMapper.DataMapperPackage.eINSTANCE.getDataMapperRoot());

			elements.put(DataMapperDiagram_2001,
					dataMapper.DataMapperPackage.eINSTANCE
							.getDataMapperDiagram());

			elements.put(Input_3001,
					dataMapper.DataMapperPackage.eINSTANCE.getInput());

			elements.put(TreeNode_3004,
					dataMapper.DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(TreeNode_3005,
					dataMapper.DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(Attribute_3006,
					dataMapper.DataMapperPackage.eINSTANCE.getAttribute());

			elements.put(InNode_3009,
					dataMapper.DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3010,
					dataMapper.DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(Element_3007,
					dataMapper.DataMapperPackage.eINSTANCE.getElement());

			elements.put(InNode_3011,
					dataMapper.DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3012,
					dataMapper.DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(Output_3002,
					dataMapper.DataMapperPackage.eINSTANCE.getOutput());

			elements.put(TreeNode_3008,
					dataMapper.DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(Concat_3013,
					dataMapper.DataMapperPackage.eINSTANCE.getConcat());

			elements.put(InNode_3014,
					dataMapper.DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3015,
					dataMapper.DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(InNode_3016,
					dataMapper.DataMapperPackage.eINSTANCE.getInNode());

			elements.put(DataMapperLink_4002,
					dataMapper.DataMapperPackage.eINSTANCE.getDataMapperLink());
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
			KNOWN_ELEMENT_TYPES.add(DataMapperDiagram_2001);
			KNOWN_ELEMENT_TYPES.add(Input_3001);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3004);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3005);
			KNOWN_ELEMENT_TYPES.add(Attribute_3006);
			KNOWN_ELEMENT_TYPES.add(InNode_3009);
			KNOWN_ELEMENT_TYPES.add(OutNode_3010);
			KNOWN_ELEMENT_TYPES.add(Element_3007);
			KNOWN_ELEMENT_TYPES.add(InNode_3011);
			KNOWN_ELEMENT_TYPES.add(OutNode_3012);
			KNOWN_ELEMENT_TYPES.add(Output_3002);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3008);
			KNOWN_ELEMENT_TYPES.add(Concat_3013);
			KNOWN_ELEMENT_TYPES.add(InNode_3014);
			KNOWN_ELEMENT_TYPES.add(OutNode_3015);
			KNOWN_ELEMENT_TYPES.add(InNode_3016);
			KNOWN_ELEMENT_TYPES.add(DataMapperLink_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case dataMapper.diagram.edit.parts.DataMapperRootEditPart.VISUAL_ID:
			return DataMapperRoot_1000;
		case dataMapper.diagram.edit.parts.DataMapperDiagramEditPart.VISUAL_ID:
			return DataMapperDiagram_2001;
		case dataMapper.diagram.edit.parts.InputEditPart.VISUAL_ID:
			return Input_3001;
		case dataMapper.diagram.edit.parts.TreeNodeEditPart.VISUAL_ID:
			return TreeNode_3004;
		case dataMapper.diagram.edit.parts.TreeNode2EditPart.VISUAL_ID:
			return TreeNode_3005;
		case dataMapper.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return Attribute_3006;
		case dataMapper.diagram.edit.parts.InNodeEditPart.VISUAL_ID:
			return InNode_3009;
		case dataMapper.diagram.edit.parts.OutNodeEditPart.VISUAL_ID:
			return OutNode_3010;
		case dataMapper.diagram.edit.parts.ElementEditPart.VISUAL_ID:
			return Element_3007;
		case dataMapper.diagram.edit.parts.InNode2EditPart.VISUAL_ID:
			return InNode_3011;
		case dataMapper.diagram.edit.parts.OutNode2EditPart.VISUAL_ID:
			return OutNode_3012;
		case dataMapper.diagram.edit.parts.OutputEditPart.VISUAL_ID:
			return Output_3002;
		case dataMapper.diagram.edit.parts.TreeNode3EditPart.VISUAL_ID:
			return TreeNode_3008;
		case dataMapper.diagram.edit.parts.ConcatEditPart.VISUAL_ID:
			return Concat_3013;
		case dataMapper.diagram.edit.parts.InNode3EditPart.VISUAL_ID:
			return InNode_3014;
		case dataMapper.diagram.edit.parts.OutNode3EditPart.VISUAL_ID:
			return OutNode_3015;
		case dataMapper.diagram.edit.parts.InNode4EditPart.VISUAL_ID:
			return InNode_3016;
		case dataMapper.diagram.edit.parts.DataMapperLinkEditPart.VISUAL_ID:
			return DataMapperLink_4002;
		}
		return null;
	}

}
