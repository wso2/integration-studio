package org.wso2.integrationstudio.datamapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.integrationstudio.datamapper.diagram.providers.DataMapperElementTypes;
import org.wso2.integrationstudio.datamapper.diagram.providers.DataMapperModelingAssistantProvider;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfTreeNodeEditPart extends DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(DataMapperElementTypes.Element_3007);
		types.add(DataMapperElementTypes.TreeNode_3003);
		types.add(DataMapperElementTypes.InNode_3020);
		types.add(DataMapperElementTypes.OutNode_3019);
		return types;
	}

}
