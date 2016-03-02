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
public class EsbModelingAssistantProviderOfInboundEndpointEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(EsbElementTypes.InboundEndpointSequenceInputConnector_3768);
		types.add(EsbElementTypes.InboundEndpointSequenceOutputConnector_3769);
		types.add(EsbElementTypes.InboundEndpointOnErrorSequenceInputConnector_3770);
		types.add(EsbElementTypes.InboundEndpointOnErrorSequenceOutputConnector_3771);
		types.add(EsbElementTypes.InboundEndpointContainer_3772);
		return types;
	}

}
