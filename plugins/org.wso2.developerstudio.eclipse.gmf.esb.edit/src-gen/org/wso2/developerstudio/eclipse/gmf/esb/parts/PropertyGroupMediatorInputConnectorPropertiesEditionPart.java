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

public interface PropertyGroupMediatorInputConnectorPropertiesEditionPart {

    /**
     * Init the incomingLinks
     * @param settings settings for the incomingLinks ReferencesTable
     */
    public void initIncomingLinks(ReferencesTableSettings settings);

    /**
     * Update the incomingLinks
     * @param newValue the incomingLinks to update
     */
    public void updateIncomingLinks();

    /**
     * Adds the given filter to the incomingLinks edition editor.
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addFilterToIncomingLinks(ViewerFilter filter);

    /**
     * Adds the given filter to the incomingLinks edition editor.
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addBusinessFilterToIncomingLinks(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the incomingLinks table
     */
    public boolean isContainedInIncomingLinksTable(EObject element);

    /**
     * Returns the internationalized title text.
     * @return the internationalized title text.
     */
    public String getTitle();

    // Start of user code for additional methods

    // End of user code
}
