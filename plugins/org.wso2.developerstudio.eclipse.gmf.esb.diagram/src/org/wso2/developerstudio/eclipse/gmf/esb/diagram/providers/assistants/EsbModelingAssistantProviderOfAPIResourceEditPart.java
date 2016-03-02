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
public class EsbModelingAssistantProviderOfAPIResourceEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(6);
		types.add(EsbElementTypes.APIResourceInputConnector_3670);
		types.add(EsbElementTypes.APIResourceOutputConnector_3671);
		types.add(EsbElementTypes.APIResourceOutSequenceOutputConnector_3730);
		types.add(EsbElementTypes.APIResourceFaultInputConnector_3672);
		types.add(EsbElementTypes.ProxyServiceContainer_3673);
		types.add(EsbElementTypes.APIResourceInSequenceInputConnector_3747);
		return types;
	}

}
