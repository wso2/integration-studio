package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.impl;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_INSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_OUTSEQ_LABEL;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_FAULTSEQ_LABEL;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.DebugPointMarkerNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MissingAttributeException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPIDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.SynapseAPIImpl;

/**
 * This class contains methods related locate and get mediators in a API
 * Resources
 */
public class APIMediatorLocator extends AbstractMediatorLocator {

    /**
     * This method returns EditPart of a API according to given information Map
     * 
     * @throws MediatorNotFoundException
     * @throws MissingAttributeException
     * @throws CoreException
     * @throws DebugPointMarkerNotFoundException
     */
    @Override
    public EditPart getMediatorEditPart(EsbServer esbServer, ESBDebugPoint breakpoint)
            throws MediatorNotFoundException, MissingAttributeException, DebugPointMarkerNotFoundException,
            CoreException {
        ESBAPIDebugPointMessage debugPointMessage = (ESBAPIDebugPointMessage) breakpoint.getLocation();
        List<Integer> positionArray = debugPointMessage.getSequence().getApi().getMediatorPosition().getPosition();
        String sequenceType = debugPointMessage.getSequence().getApi().getSequenceType();
        SynapseAPIImpl api = (SynapseAPIImpl) esbServer.eContents().get(INDEX_OF_FIRST_ELEMENT);
        APIResource apiResource = getMatchingAPIResource(api, debugPointMessage);
        if (sequenceType.equals(API_FAULTSEQ_LABEL)) {
            return getMediatorInFaultSeq(
                    apiResource.getContainer().getFaultContainer().getMediatorFlow().getChildren(), positionArray);
        } else if (sequenceType.equals(API_INSEQ_LABEL)) {
            return getMediatorFromMediationFlow(apiResource.getOutputConnector(), positionArray);
        } else if (sequenceType.equals(API_OUTSEQ_LABEL)) {
            return getMediatorFromMediationFlow(apiResource.getOutSequenceOutputConnector(), positionArray);
        } else {
            throw new IllegalArgumentException("Unknown sequence type for api resource detected : " + sequenceType);
        }
    }

    private APIResource getMatchingAPIResource(SynapseAPIImpl api, ESBAPIDebugPointMessage debugPointMessage)
            throws MediatorNotFoundException {
        EList<APIResource> apiResources = api.getResources();
        for (APIResource apiResource : apiResources) {
            String urlValue = "";
            String urlValueOfMessage = "";
            if (isMethodEqual(apiResource, debugPointMessage.getSequence().getApi().getResourse().getMethod())) {
                switch (apiResource.getUrlStyle().getValue()) {
                case ApiResourceUrlStyle.URI_TEMPLATE_VALUE:
                    urlValue = apiResource.getUriTemplate();
                    urlValueOfMessage = debugPointMessage.getSequence().getApi().getResourse().getUriTemplate();
                    break;
                case ApiResourceUrlStyle.URL_MAPPING_VALUE:
                    urlValue = apiResource.getUrlMapping();
                    urlValueOfMessage = debugPointMessage.getSequence().getApi().getResourse().getUrlMapping();
                    break;
                default:
                    break;
                }
                if (urlValueOfMessage != null && urlValueOfMessage.endsWith(urlValue)) {
                    return apiResource;
                }
            }
        }
        throw new MediatorNotFoundException("Matching API Resource not found for the specific location of mediator: ");
    }

    private boolean isMethodEqual(APIResource apiResource, String methodValue) {

        if (methodValue == null) {
            if (StringUtils.isEmpty(ESBDebuggerUtil.getMethodValuesFromResource(apiResource))) {
                return true;
            }
        } else if (methodValue.equalsIgnoreCase(ESBDebuggerUtil.getMethodValuesFromResource(apiResource))) {
            return true;
        }
        return false;
    }

}
