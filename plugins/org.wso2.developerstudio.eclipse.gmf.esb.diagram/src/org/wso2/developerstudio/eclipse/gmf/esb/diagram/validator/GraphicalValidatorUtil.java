/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator;

import org.eclipse.draw2d.RoundedRectangle;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.CloneMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EntitlementMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGroupingShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FilterMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SwitchMediatorGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.complexFiguredAbstractMediator;

public class GraphicalValidatorUtil {

    /**
     * This method add validation mark to the selected edit part to show
     * the incomplete mediator configuration
     */
    public static void addValidationMark(AbstractMediator part) {
        if (part instanceof FixedSizedAbstractMediator) {
            ((FixedSizedAbstractMediator) part).getPrimaryShape().addValidationMark();
        } else if (part instanceof complexFiguredAbstractMediator) {
            RoundedRectangle shape = ((complexFiguredAbstractMediator) part).getPrimaryShape();
            if (shape instanceof EsbGroupingShape) {
                ((EsbGroupingShape) shape).addValidationMark();
            } else if (shape instanceof SwitchMediatorGraphicalShape) {
                ((SwitchMediatorGraphicalShape) shape).addValidationMark();
            } else if (shape instanceof FilterMediatorGraphicalShape) {
                ((FilterMediatorGraphicalShape) shape).addValidationMark();
            } else if (shape instanceof CloneMediatorGraphicalShape) {
                ((CloneMediatorGraphicalShape) shape).addValidationMark();
            } else if (shape instanceof EntitlementMediatorGraphicalShape) {
                ((EntitlementMediatorGraphicalShape) shape).addValidationMark();
            }
        }
    }

    /**
     * This method remove validation mark from the selected edit part to show
     * the incomplete mediator configuration
     */
    public static void removeValidationMark(AbstractMediator part) {
        if (part instanceof FixedSizedAbstractMediator) {
            ((FixedSizedAbstractMediator) part).getPrimaryShape().removeValidationMark();
        } else if (part instanceof complexFiguredAbstractMediator) {
            RoundedRectangle shape = ((complexFiguredAbstractMediator) part).getPrimaryShape();
            if (shape instanceof EsbGroupingShape) {
                ((EsbGroupingShape) shape).removeValidationMark();
            } else if (shape instanceof SwitchMediatorGraphicalShape) {
                ((SwitchMediatorGraphicalShape) shape).removeValidationMark();
            } else if (shape instanceof FilterMediatorGraphicalShape) {
                ((FilterMediatorGraphicalShape) shape).removeValidationMark();
            } else if (shape instanceof CloneMediatorGraphicalShape) {
                ((CloneMediatorGraphicalShape) shape).removeValidationMark();
            } else if (shape instanceof EntitlementMediatorGraphicalShape) {
                ((EntitlementMediatorGraphicalShape) shape).removeValidationMark();
            }
        }
    }
}