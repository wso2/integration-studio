package org.wso2.developerstudio.datamapper.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
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
import org.wso2.developerstudio.datamapper.diagram.edit.parts.TrimEditPart;
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
	public static final IElementType DataMapperRoot_1000 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.DataMapperRoot_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Input_2002 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Input_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Output_2003 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Output_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Equal_2005 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Equal_2005"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Subtract_2013 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Subtract_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Concat_2006 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Concat_2006"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Add_2012 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Add_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Split_2007 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Split_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Constant_2008 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Constant_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LowerCase_2009 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.LowerCase_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Contains_2010 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Contains_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType UpperCase_2011 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.UpperCase_2011"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Multiply_2014 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Multiply_2014"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Divide_2015 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Divide_2015"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Celi_2016 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Celi_2016"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Floor_2017 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Floor_2017"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Round_2018 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Round_2018"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType SetPrecision_2019 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.SetPrecision_2019"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType AbsoluteValue_2020 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.AbsoluteValue_2020"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType StringLength_2021 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.StringLength_2021"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType StartsWith_2022 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.StartsWith_2022"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType EndsWith_2023 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.EndsWith_2023"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Substring_2024 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Substring_2024"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType IfElse_2025 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.IfElse_2025"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType AND_2026 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.AND_2026"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType OR_2027 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OR_2027"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType NOT_2028 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.NOT_2028"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Trim_2029 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Trim_2029"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Replace_2030 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Replace_2030"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Match_2031 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Match_2031"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Min_2032 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Min_2032"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Max_2033 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Max_2033"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType CustomFunction_2034 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.CustomFunction_2034"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Properties_2035 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Properties_2035"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Compare_2036 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Compare_2036"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType StringToNumber_2037 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.StringToNumber_2037"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType StringToBoolean_2038 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.StringToBoolean_2038"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Clone_2039 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Clone_2039"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType ToString_2040 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.ToString_2040"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType GlobalVariable_2041 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.GlobalVariable_2041"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType AdvancedCustomFunction_2042 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.AdvancedCustomFunction_2042"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3002 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3003 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3020 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.InNode_3020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3019 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Element_3007 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.Element_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3008 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.InNode_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3009 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TreeNode_3011 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.TreeNode_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorBasicContainer_3012 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OperatorBasicContainer_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorLeftContainer_3013 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OperatorLeftContainer_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorLeftConnector_3014 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OperatorLeftConnector_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InNode_3015 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.InNode_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorRightContainer_3016 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OperatorRightContainer_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OperatorRightConnector_3017 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OperatorRightConnector_3017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OutNode_3018 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.OutNode_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataMapperLink_4001 = getElementType(
			"org.wso2.developerstudio.visualdatamapper.diagram.DataMapperLink_4001"); //$NON-NLS-1$

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

			elements.put(Subtract_2013, DataMapperPackage.eINSTANCE.getSubtract());

			elements.put(Concat_2006, DataMapperPackage.eINSTANCE.getConcat());

			elements.put(Add_2012, DataMapperPackage.eINSTANCE.getAdd());

			elements.put(Split_2007, DataMapperPackage.eINSTANCE.getSplit());

			elements.put(Constant_2008, DataMapperPackage.eINSTANCE.getConstant());

			elements.put(LowerCase_2009, DataMapperPackage.eINSTANCE.getLowerCase());

			elements.put(Contains_2010, DataMapperPackage.eINSTANCE.getContains());

			elements.put(UpperCase_2011, DataMapperPackage.eINSTANCE.getUpperCase());

			elements.put(Multiply_2014, DataMapperPackage.eINSTANCE.getMultiply());

			elements.put(Divide_2015, DataMapperPackage.eINSTANCE.getDivide());

			elements.put(Celi_2016, DataMapperPackage.eINSTANCE.getCeli());

			elements.put(Floor_2017, DataMapperPackage.eINSTANCE.getFloor());

			elements.put(Round_2018, DataMapperPackage.eINSTANCE.getRound());

			elements.put(SetPrecision_2019, DataMapperPackage.eINSTANCE.getSetPrecision());

			elements.put(AbsoluteValue_2020, DataMapperPackage.eINSTANCE.getAbsoluteValue());

			elements.put(StringLength_2021, DataMapperPackage.eINSTANCE.getStringLength());

			elements.put(StartsWith_2022, DataMapperPackage.eINSTANCE.getStartsWith());

			elements.put(EndsWith_2023, DataMapperPackage.eINSTANCE.getEndsWith());

			elements.put(Substring_2024, DataMapperPackage.eINSTANCE.getSubstring());

			elements.put(IfElse_2025, DataMapperPackage.eINSTANCE.getIfElse());

			elements.put(AND_2026, DataMapperPackage.eINSTANCE.getAND());

			elements.put(OR_2027, DataMapperPackage.eINSTANCE.getOR());

			elements.put(NOT_2028, DataMapperPackage.eINSTANCE.getNOT());

			elements.put(Trim_2029, DataMapperPackage.eINSTANCE.getTrim());

			elements.put(Replace_2030, DataMapperPackage.eINSTANCE.getReplace());

			elements.put(Match_2031, DataMapperPackage.eINSTANCE.getMatch());

			elements.put(Min_2032, DataMapperPackage.eINSTANCE.getMin());

			elements.put(Max_2033, DataMapperPackage.eINSTANCE.getMax());

			elements.put(CustomFunction_2034, DataMapperPackage.eINSTANCE.getCustomFunction());

			elements.put(Properties_2035, DataMapperPackage.eINSTANCE.getProperties());

			elements.put(Compare_2036, DataMapperPackage.eINSTANCE.getCompare());

			elements.put(StringToNumber_2037, DataMapperPackage.eINSTANCE.getStringToNumber());

			elements.put(StringToBoolean_2038, DataMapperPackage.eINSTANCE.getStringToBoolean());

			elements.put(Clone_2039, DataMapperPackage.eINSTANCE.getClone());

			elements.put(ToString_2040, DataMapperPackage.eINSTANCE.getToString());

			elements.put(GlobalVariable_2041, DataMapperPackage.eINSTANCE.getGlobalVariable());

			elements.put(AdvancedCustomFunction_2042, DataMapperPackage.eINSTANCE.getAdvancedCustomFunction());

			elements.put(TreeNode_3002, DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(Element_3007, DataMapperPackage.eINSTANCE.getElement());

			elements.put(InNode_3008, DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3009, DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(TreeNode_3003, DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(InNode_3020, DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OutNode_3019, DataMapperPackage.eINSTANCE.getOutNode());

			elements.put(TreeNode_3011, DataMapperPackage.eINSTANCE.getTreeNode());

			elements.put(OperatorBasicContainer_3012, DataMapperPackage.eINSTANCE.getOperatorBasicContainer());

			elements.put(OperatorLeftContainer_3013, DataMapperPackage.eINSTANCE.getOperatorLeftContainer());

			elements.put(OperatorLeftConnector_3014, DataMapperPackage.eINSTANCE.getOperatorLeftConnector());

			elements.put(InNode_3015, DataMapperPackage.eINSTANCE.getInNode());

			elements.put(OperatorRightContainer_3016, DataMapperPackage.eINSTANCE.getOperatorRightContainer());

			elements.put(OperatorRightConnector_3017, DataMapperPackage.eINSTANCE.getOperatorRightConnector());

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
			KNOWN_ELEMENT_TYPES.add(Subtract_2013);
			KNOWN_ELEMENT_TYPES.add(Concat_2006);
			KNOWN_ELEMENT_TYPES.add(Add_2012);
			KNOWN_ELEMENT_TYPES.add(Split_2007);
			KNOWN_ELEMENT_TYPES.add(Constant_2008);
			KNOWN_ELEMENT_TYPES.add(LowerCase_2009);
			KNOWN_ELEMENT_TYPES.add(Contains_2010);
			KNOWN_ELEMENT_TYPES.add(UpperCase_2011);
			KNOWN_ELEMENT_TYPES.add(Multiply_2014);
			KNOWN_ELEMENT_TYPES.add(Divide_2015);
			KNOWN_ELEMENT_TYPES.add(Celi_2016);
			KNOWN_ELEMENT_TYPES.add(Floor_2017);
			KNOWN_ELEMENT_TYPES.add(Round_2018);
			KNOWN_ELEMENT_TYPES.add(SetPrecision_2019);
			KNOWN_ELEMENT_TYPES.add(AbsoluteValue_2020);
			KNOWN_ELEMENT_TYPES.add(StringLength_2021);
			KNOWN_ELEMENT_TYPES.add(StartsWith_2022);
			KNOWN_ELEMENT_TYPES.add(EndsWith_2023);
			KNOWN_ELEMENT_TYPES.add(Substring_2024);
			KNOWN_ELEMENT_TYPES.add(IfElse_2025);
			KNOWN_ELEMENT_TYPES.add(AND_2026);
			KNOWN_ELEMENT_TYPES.add(OR_2027);
			KNOWN_ELEMENT_TYPES.add(NOT_2028);
			KNOWN_ELEMENT_TYPES.add(Trim_2029);
			KNOWN_ELEMENT_TYPES.add(Replace_2030);
			KNOWN_ELEMENT_TYPES.add(Match_2031);
			KNOWN_ELEMENT_TYPES.add(Min_2032);
			KNOWN_ELEMENT_TYPES.add(Max_2033);
			KNOWN_ELEMENT_TYPES.add(CustomFunction_2034);
			KNOWN_ELEMENT_TYPES.add(Properties_2035);
			KNOWN_ELEMENT_TYPES.add(Compare_2036);
			KNOWN_ELEMENT_TYPES.add(StringToNumber_2037);
			KNOWN_ELEMENT_TYPES.add(StringToBoolean_2038);
			KNOWN_ELEMENT_TYPES.add(Clone_2039);
			KNOWN_ELEMENT_TYPES.add(ToString_2040);
			KNOWN_ELEMENT_TYPES.add(GlobalVariable_2041);
			KNOWN_ELEMENT_TYPES.add(AdvancedCustomFunction_2042);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3002);
			KNOWN_ELEMENT_TYPES.add(Element_3007);
			KNOWN_ELEMENT_TYPES.add(InNode_3008);
			KNOWN_ELEMENT_TYPES.add(OutNode_3009);
			KNOWN_ELEMENT_TYPES.add(TreeNode_3003);
			KNOWN_ELEMENT_TYPES.add(InNode_3020);
			KNOWN_ELEMENT_TYPES.add(OutNode_3019);
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
		case SubtractEditPart.VISUAL_ID:
			return Subtract_2013;
		case ConcatEditPart.VISUAL_ID:
			return Concat_2006;
		case AddEditPart.VISUAL_ID:
			return Add_2012;
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
		case MultiplyEditPart.VISUAL_ID:
			return Multiply_2014;
		case DivideEditPart.VISUAL_ID:
			return Divide_2015;
		case CeliEditPart.VISUAL_ID:
			return Celi_2016;
		case FloorEditPart.VISUAL_ID:
			return Floor_2017;
		case RoundEditPart.VISUAL_ID:
			return Round_2018;
		case SetPrecisionEditPart.VISUAL_ID:
			return SetPrecision_2019;
		case AbsoluteValueEditPart.VISUAL_ID:
			return AbsoluteValue_2020;
		case StringLengthEditPart.VISUAL_ID:
			return StringLength_2021;
		case StartsWithEditPart.VISUAL_ID:
			return StartsWith_2022;
		case EndsWithEditPart.VISUAL_ID:
			return EndsWith_2023;
		case SubstringEditPart.VISUAL_ID:
			return Substring_2024;
		case IfElseEditPart.VISUAL_ID:
			return IfElse_2025;
		case ANDEditPart.VISUAL_ID:
			return AND_2026;
		case OREditPart.VISUAL_ID:
			return OR_2027;
		case NOTEditPart.VISUAL_ID:
			return NOT_2028;
		case TrimEditPart.VISUAL_ID:
			return Trim_2029;
		case ReplaceEditPart.VISUAL_ID:
			return Replace_2030;
		case MatchEditPart.VISUAL_ID:
			return Match_2031;
		case MinEditPart.VISUAL_ID:
			return Min_2032;
		case MaxEditPart.VISUAL_ID:
			return Max_2033;
		case CustomFunctionEditPart.VISUAL_ID:
			return CustomFunction_2034;
		case PropertiesEditPart.VISUAL_ID:
			return Properties_2035;
		case CompareEditPart.VISUAL_ID:
			return Compare_2036;
		case StringToNumberEditPart.VISUAL_ID:
			return StringToNumber_2037;
		case StringToBooleanEditPart.VISUAL_ID:
			return StringToBoolean_2038;
		case CloneEditPart.VISUAL_ID:
			return Clone_2039;
		case ToStringEditPart.VISUAL_ID:
			return ToString_2040;
		case GlobalVariableEditPart.VISUAL_ID:
			return GlobalVariable_2041;
		case AdvancedCustomFunctionEditPart.VISUAL_ID:
			return AdvancedCustomFunction_2042;
		case TreeNodeEditPart.VISUAL_ID:
			return TreeNode_3002;
		case ElementEditPart.VISUAL_ID:
			return Element_3007;
		case InNode2EditPart.VISUAL_ID:
			return InNode_3008;
		case OutNode2EditPart.VISUAL_ID:
			return OutNode_3009;
		case TreeNode2EditPart.VISUAL_ID:
			return TreeNode_3003;
		case InNodeEditPart.VISUAL_ID:
			return InNode_3020;
		case OutNodeEditPart.VISUAL_ID:
			return OutNode_3019;
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
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

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
