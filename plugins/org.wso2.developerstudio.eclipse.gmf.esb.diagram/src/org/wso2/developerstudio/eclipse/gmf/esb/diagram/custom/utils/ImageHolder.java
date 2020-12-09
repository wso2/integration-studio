/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.CALL_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.SEND_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.CACHE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.VALIDATE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.ITERATE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.FOREACH_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.RULE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.THROTTLE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.CLONE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.ENTITLEMENT_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.FILTER_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.SWITCH_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.LOG_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.AGGREGATE_MEDIATOR_ICON_PATH;

public class ImageHolder {

    private static final String ARROW_WEST = "icons/ico20/arrowWest.png";
    private static final String ARROW_EAST = "icons/ico20/arrowEast.png";
    private static final String XPATH_ATTRIBUTE_ICON = "icons/xpath/xmlAttribute.png";
    private static final String XPATH_ELEMENT_ICON = "icons/xpath/xmlElement.png";

    private Image arrowWestImage;
    private Image arrowEastImage;
    private Image cloneMediatorImage;
    private Image entitlementMediatorImage;
    private Image filterMediatorImage;
    private Image switchMediatorImage;
    private Image aggregateMediatorImage;
    private Image logMediatorImage;
    private Image callMediatorImage;
    private Image cacheMediatorImage;
    private Image sendMediatorImage;
    private Image validateMediatorImage;
    private Image iterateMediatorImage;
    private Image forEachMediatorImage;
    private Image ruleMediatorImage;
    private Image throttleMediatorImage;
    private Image xPathAttributeImage;
    private Image xPathElementImage;

    private ImageHolder() {

        ImageDescriptor arrowWestImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(ARROW_WEST);
        ImageDescriptor arrowEastImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(ARROW_EAST);
        ImageDescriptor cloneMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(CLONE_MEDIATOR_ICON_PATH);
        ImageDescriptor entitlementMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(ENTITLEMENT_MEDIATOR_ICON_PATH);
        ImageDescriptor filterMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(FILTER_MEDIATOR_ICON_PATH);
        ImageDescriptor switchMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(SWITCH_MEDIATOR_ICON_PATH);
        ImageDescriptor aggregateMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(AGGREGATE_MEDIATOR_ICON_PATH);
        ImageDescriptor logMediatorImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(LOG_MEDIATOR_ICON_PATH);
        ImageDescriptor callMediatorImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(CALL_MEDIATOR_ICON_PATH);
        ImageDescriptor cacheMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(CACHE_MEDIATOR_ICON_PATH);
        ImageDescriptor sendMediatorImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(SEND_MEDIATOR_ICON_PATH);
        ImageDescriptor validateMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(VALIDATE_MEDIATOR_ICON_PATH);
        ImageDescriptor iterateMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(ITERATE_MEDIATOR_ICON_PATH);
        ImageDescriptor forEachMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(FOREACH_MEDIATOR_ICON_PATH);
        ImageDescriptor ruleMediatorImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(RULE_MEDIATOR_ICON_PATH);
        ImageDescriptor throttleMediatorImgDesc = EsbDiagramEditorPlugin
                .getBundledImageDescriptor(THROTTLE_MEDIATOR_ICON_PATH);
        ImageDescriptor xPathAttributeImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(XPATH_ATTRIBUTE_ICON);
        ImageDescriptor xPathElementImgDesc = EsbDiagramEditorPlugin.getBundledImageDescriptor(XPATH_ELEMENT_ICON);

        arrowWestImage = arrowWestImgDesc.createImage();
        arrowEastImage = arrowEastImgDesc.createImage();
        cloneMediatorImage = cloneMediatorImgDesc.createImage();
        entitlementMediatorImage = entitlementMediatorImgDesc.createImage();
        filterMediatorImage = filterMediatorImgDesc.createImage();
        switchMediatorImage = switchMediatorImgDesc.createImage();
        aggregateMediatorImage = aggregateMediatorImgDesc.createImage();
        logMediatorImage = logMediatorImgDesc.createImage();
        callMediatorImage = callMediatorImgDesc.createImage();
        cacheMediatorImage = cacheMediatorImgDesc.createImage();
        sendMediatorImage = sendMediatorImgDesc.createImage();
        validateMediatorImage = validateMediatorImgDesc.createImage();
        iterateMediatorImage = iterateMediatorImgDesc.createImage();
        forEachMediatorImage = forEachMediatorImgDesc.createImage();
        ruleMediatorImage = ruleMediatorImgDesc.createImage();
        throttleMediatorImage = throttleMediatorImgDesc.createImage();
        xPathAttributeImage = xPathAttributeImgDesc.createImage();
        xPathElementImage = xPathElementImgDesc.createImage();
    }

    public Image getArrowWestImage() {
        return arrowWestImage;
    }

    public Image getArrowEastImage() {
        return arrowEastImage;
    }

    public Image getMediatorImage(String iconPath) {
        if (iconPath.equals(FILTER_MEDIATOR_ICON_PATH)) {
            return filterMediatorImage;
        } else if (iconPath.equals(CLONE_MEDIATOR_ICON_PATH)) {
            return cloneMediatorImage;
        } else if (iconPath.equals(ENTITLEMENT_MEDIATOR_ICON_PATH)) {
            return entitlementMediatorImage;
        } else if (iconPath.equals(AGGREGATE_MEDIATOR_ICON_PATH)) {
            return aggregateMediatorImage;
        } else if (iconPath.equals(CALL_MEDIATOR_ICON_PATH)) {
            return callMediatorImage;
        } else if (iconPath.equals(SEND_MEDIATOR_ICON_PATH)) {
            return sendMediatorImage;
        } else if (iconPath.equals(CACHE_MEDIATOR_ICON_PATH)) {
            return cacheMediatorImage;
        } else if (iconPath.equals(VALIDATE_MEDIATOR_ICON_PATH)) {
            return validateMediatorImage;
        } else if (iconPath.equals(ITERATE_MEDIATOR_ICON_PATH)) {
            return iterateMediatorImage;
        } else if (iconPath.equals(FOREACH_MEDIATOR_ICON_PATH)) {
            return forEachMediatorImage;
        } else if (iconPath.equals(RULE_MEDIATOR_ICON_PATH)) {
            return ruleMediatorImage;
        } else if (iconPath.equals(THROTTLE_MEDIATOR_ICON_PATH)) {
            return throttleMediatorImage;
        }
        return null;
    }

    public Image getSwitchMediatorImage() {
        return switchMediatorImage;
    }

    public Image getLogMediatorImage() {
        return logMediatorImage;
    }

    public Image getXPathAttributeImage() {
        return xPathAttributeImage;
    }

    public Image getXPathElementImage() {
        return xPathElementImage;
    }

    public static ImageHolder getInstance() {
        return ImageHolderInstanceHolder.IMAGEHOLDER_INSTANCE;
    }

    private static class ImageHolderInstanceHolder {
        private static final ImageHolder IMAGEHOLDER_INSTANCE = new ImageHolder();
    }
}
