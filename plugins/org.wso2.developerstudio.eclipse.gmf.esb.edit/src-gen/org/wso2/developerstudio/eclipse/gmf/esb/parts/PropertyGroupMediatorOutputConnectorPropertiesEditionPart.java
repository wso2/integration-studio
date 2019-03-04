/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
  * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
  *      http://www.apache.org/licenses/LICENSE-2.0
  * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;

public interface PropertyGroupMediatorOutputConnectorPropertiesEditionPart {

    /**
     * Init the commentMediators
     * @param current the current value
     * @param containgFeature the feature where to navigate if necessary
     * @param feature the feature to manage
     */
    public void initCommentMediators(ReferencesTableSettings settings);

    /**
     * Update the commentMediators
     * @param newValue the commentMediators to update
     */
    public void updateCommentMediators();

    /**
     * Adds the given filter to the commentMediators edition editor.
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addFilterToCommentMediators(ViewerFilter filter);

    /**
     * Adds the given filter to the commentMediators edition editor.
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addBusinessFilterToCommentMediators(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the commentMediators table
     */
    public boolean isContainedInCommentMediatorsTable(EObject element);

    /**
     * Returns the internationalized title text.
     * @return the internationalized title text.
     */
    public String getTitle();

    // Start of user code for additional methods

    // End of user code
}
