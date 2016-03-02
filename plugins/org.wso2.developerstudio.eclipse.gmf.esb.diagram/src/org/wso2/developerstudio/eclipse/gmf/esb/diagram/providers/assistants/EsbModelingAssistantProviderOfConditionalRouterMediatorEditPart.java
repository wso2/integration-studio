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
public class EsbModelingAssistantProviderOfConditionalRouterMediatorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(EsbElementTypes.ConditionalRouterMediatorInputConnector_3636);
		types.add(EsbElementTypes.ConditionalRouterMediatorOutputConnector_3637);
		types.add(EsbElementTypes.ConditionalRouterMediatorAdditionalOutputConnector_3638);
		types.add(EsbElementTypes.MediatorFlow_3639);
		return types;
	}

}
