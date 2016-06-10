package org.wso2.developerstudio.datamapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperElementTypes;
import org.wso2.developerstudio.datamapper.diagram.providers.DataMapperModelingAssistantProvider;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfDataMapperRootEditPart extends DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(26);
		types.add(DataMapperElementTypes.Input_2002);
		types.add(DataMapperElementTypes.Output_2003);
		types.add(DataMapperElementTypes.Equal_2005);
		types.add(DataMapperElementTypes.Subtract_2013);
		types.add(DataMapperElementTypes.Concat_2006);
		types.add(DataMapperElementTypes.Add_2012);
		types.add(DataMapperElementTypes.Split_2007);
		types.add(DataMapperElementTypes.Constant_2008);
		types.add(DataMapperElementTypes.LowerCase_2009);
		types.add(DataMapperElementTypes.Contains_2010);
		types.add(DataMapperElementTypes.UpperCase_2011);
		types.add(DataMapperElementTypes.Multiply_2014);
		types.add(DataMapperElementTypes.Divide_2015);
		types.add(DataMapperElementTypes.Celi_2016);
		types.add(DataMapperElementTypes.Floor_2017);
		types.add(DataMapperElementTypes.Round_2018);
		types.add(DataMapperElementTypes.SetPrecision_2019);
		types.add(DataMapperElementTypes.AbsoluteValue_2020);
		types.add(DataMapperElementTypes.StringLength_2021);
		types.add(DataMapperElementTypes.StartsWith_2022);
		types.add(DataMapperElementTypes.EndsWith_2023);
		types.add(DataMapperElementTypes.Substring_2024);
		types.add(DataMapperElementTypes.IfElse_2025);
		types.add(DataMapperElementTypes.AND_2026);
		types.add(DataMapperElementTypes.OR_2027);
		types.add(DataMapperElementTypes.NOT_2028);
		return types;
	}

}
