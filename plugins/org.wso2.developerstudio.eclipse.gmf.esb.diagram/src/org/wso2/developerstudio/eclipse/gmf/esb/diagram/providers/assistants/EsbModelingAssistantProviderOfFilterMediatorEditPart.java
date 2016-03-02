package org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbModelingAssistantProvider;

/**
 * @generated
 */
public class EsbModelingAssistantProviderOfFilterMediatorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(EsbElementTypes.FilterMediatorInputConnector_3010);
		types.add(EsbElementTypes.FilterMediatorOutputConnector_3534);
		types.add(EsbElementTypes.FilterMediatorPassOutputConnector_3011);
		types.add(EsbElementTypes.FilterMediatorFailOutputConnector_3012);
		types.add(EsbElementTypes.FilterContainer_3531);
		return types;
	}

}
