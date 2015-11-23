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
public class EsbModelingAssistantProviderOfThrottleMediatorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(EsbElementTypes.ThrottleMediatorInputConnector_3121);
		types.add(EsbElementTypes.ThrottleMediatorOutputConnector_3122);
		types.add(EsbElementTypes.ThrottleMediatorOnAcceptOutputConnector_3581);
		types.add(EsbElementTypes.ThrottleMediatorOnRejectOutputConnector_3582);
		types.add(EsbElementTypes.ThrottleContainer_3583);
		return types;
	}

}
