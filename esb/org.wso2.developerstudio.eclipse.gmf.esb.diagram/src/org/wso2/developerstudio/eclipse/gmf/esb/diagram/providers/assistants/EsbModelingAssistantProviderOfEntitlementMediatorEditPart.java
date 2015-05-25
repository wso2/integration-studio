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
public class EsbModelingAssistantProviderOfEntitlementMediatorEditPart extends EsbModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(7);
		types.add(EsbElementTypes.EntitlementMediatorInputConnector_3055);
		types.add(EsbElementTypes.EntitlementMediatorOutputConnector_3056);
		types.add(EsbElementTypes.EntitlementMediatorOnRejectOutputConnector_3748);
		types.add(EsbElementTypes.EntitlementMediatorOnAcceptOutputConnector_3749);
		types.add(EsbElementTypes.EntitlementMediatorAdviceOutputConnector_3750);
		types.add(EsbElementTypes.EntitlementMediatorObligationsOutputConnector_3751);
		types.add(EsbElementTypes.EntitlementContainer_3752);
		return types;
	}

}
