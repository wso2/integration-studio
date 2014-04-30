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
public class DataMapperModelingAssistantProviderOfDataMapperRootEditPart extends
		DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(9);
		types.add(DataMapperElementTypes.Input_2002);
		types.add(DataMapperElementTypes.Output_2003);
		types.add(DataMapperElementTypes.Equal_2005);
		types.add(DataMapperElementTypes.Concat_2006);
		types.add(DataMapperElementTypes.Split_2007);
		types.add(DataMapperElementTypes.Constant_2008);
		types.add(DataMapperElementTypes.LowerCase_2009);
		types.add(DataMapperElementTypes.Contains_2010);
		types.add(DataMapperElementTypes.UpperCase_2011);
		return types;
	}

}
