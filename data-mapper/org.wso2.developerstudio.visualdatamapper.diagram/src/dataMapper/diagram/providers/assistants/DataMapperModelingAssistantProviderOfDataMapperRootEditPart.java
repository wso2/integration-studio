package dataMapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfDataMapperRootEditPart extends
		dataMapper.diagram.providers.DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(9);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Input_2002);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Output_2003);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Equal_2005);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Concat_2006);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Split_2007);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Constant_2008);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.LowerCase_2009);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Contains_2010);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.UpperCase_2011);
		return types;
	}

}
