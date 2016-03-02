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
public class EsbModelingAssistantProviderOfValidateMediatorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(EsbElementTypes.ValidateMediatorInputConnector_3624);
		types.add(EsbElementTypes.ValidateMediatorOutputConnector_3625);
		types.add(EsbElementTypes.ValidateMediatorOnFailOutputConnector_3626);
		types.add(EsbElementTypes.MediatorFlow_3627);
		return types;
	}

}
