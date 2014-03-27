package dataMapper.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class DataMapperModelingAssistantProviderOfOperatorBasicContainerEditPart extends
		dataMapper.diagram.providers.DataMapperModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.OperatorLeftContainer_3013);
		types.add(dataMapper.diagram.providers.DataMapperElementTypes.OperatorRightContainer_3016);
		return types;
	}

}
