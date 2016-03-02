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
public class EsbModelingAssistantProviderOfSwitchMediatorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(EsbElementTypes.SwitchMediatorInputConnector_3042);
		types.add(EsbElementTypes.SwitchMediatorOutputConnector_3499);
		types.add(EsbElementTypes.SwitchCaseBranchOutputConnector_3043);
		types.add(EsbElementTypes.SwitchDefaultBranchOutputConnector_3044);
		types.add(EsbElementTypes.SwitchMediatorContainer_3500);
		return types;
	}

}
