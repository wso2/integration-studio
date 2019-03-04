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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;

public interface PropertyGroupMediatorPropertiesEditionPart {

    /**
     * @return the description
     */
    public String getDescription();

    /**
     * Defines a new description
     * @param newValue the new description to set
     */
    public void setDescription(String newValue);

    /**
     * @return the commentsList
     */
    public EList getCommentsList();

    /**
     * Defines a new commentsList
     * @param newValue the new commentsList to set
     */
    public void setCommentsList(EList newValue);

    /**
     * Add a value to the commentsList multivalued attribute. 
     * @param newValue the value to add
     */
    public void addToCommentsList(Object newValue);

    /**
     * Remove a value to the commentsList multivalued attribute.
     * @param newValue the value to remove
     */
    public void removeToCommentsList(Object newValue);

    /**
     * @return the Reverse
     */
    public Boolean getReverse();

    /**
     * Defines a new Reverse
     * @param newValue the new Reverse to set
     */
    public void setReverse(Boolean newValue);

    /**
     * Init the properties
     * @param current the current value
     * @param containgFeature the feature where to navigate if necessary
     * @param feature the feature to manage
     */
    public void initProperties(ReferencesTableSettings settings);

    /**
     * Update the properties 
     * @param newValue the properties to update 
     */
    public void updateProperties();

    /**
     * Adds the given filter to the properties edition editor.
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter) 
     */
    public void addFilterToProperties(ViewerFilter filter);

    /**
     * Adds the given filter to the properties edition editor. 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     */
    public void addBusinessFilterToProperties(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the properties table
     */
    public boolean isContainedInPropertiesTable(EObject element);

    /**
     * Returns the internationalized title text.
     * @return the internationalized title text.
     */
    public String getTitle();

    // Start of user code for additional methods

    // End of user code
}
