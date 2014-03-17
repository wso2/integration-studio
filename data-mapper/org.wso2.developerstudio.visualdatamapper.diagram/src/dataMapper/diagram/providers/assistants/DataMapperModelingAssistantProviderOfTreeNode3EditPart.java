package dataMapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfTreeNode3EditPart extends
		dataMapper.diagram.providers.DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.TreeNode_3003);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Attribute_3004);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.Element_3007);
		return types;
	}

}
