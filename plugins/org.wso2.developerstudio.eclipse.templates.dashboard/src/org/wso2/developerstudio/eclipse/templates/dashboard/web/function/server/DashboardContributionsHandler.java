/**
 * Copyright 2009-2018 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.templates.dashboard.web.function.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.model.DashboardCategory;
import org.wso2.developerstudio.eclipse.templates.dashboard.web.model.DashboardLink;

/**
 * Utility class for reading developer studio dashboard contributions. 
 * This lists all the wizard link categories along with the corresponding wizard details.
 * Wizard link should be added as below to plugin.xml in each of the plugins which contribute templates
 * ex :-     
 *  <extension
 *         point="org.wso2.developerstudio.eclipse.template.dashboad.link">
 *     <wizardCategory category="org.wso2.developerstudio.templates"/>
 *     <category id="dashboard.category.esb.template" showTitle="false" (Category should only be defined once for each category)
 *               title="ESB Templates"
 *               priority="1">
 *      </category>
 *     <wizardLink category="dashboard.category.esb.template" id="dashboard.wizardLink.esb.template.project"
 *                 wizard="org.wso2.developerstudio.wizards.esb.template" description="Test 1 Description">
 *     </wizardLink>
 *  </extension>
 *  
 */
public class DashboardContributionsHandler {

    //Dashboard links are defined under this extension point id (Refer plugin.xml)
    private static final String EXT_POINT_ID = "org.wso2.developerstudio.eclipse.template.dashboad.link";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static List<String> categoryContributions = new ArrayList<String>();

    private static Map<String, String> wizardLinks = new LinkedHashMap<String, String>();

    private static Map<String, IConfigurationElement> customActions = new LinkedHashMap<String, IConfigurationElement>();

    private static Map<String, DashboardCategory> dashboardCategories = new LinkedHashMap<String, DashboardCategory>();

    //This static block reads contribution elements from plugin.xml and stores it to categoryContributions(At class startup)
    static {
        IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_POINT_ID);
        JSEmbeddedFunctions jsf = new JSEmbeddedFunctions();
        for (IConfigurationElement element : config) {
            IExtension extension = element.getDeclaringExtension();
            //Fill wizard category elements along with related wizard links
            if ("wizardCategory".equals(element.getName())) {
                String category = element.getAttribute("category");
                getCategoryContributions().add(category);
            } else if ("category".equals(element.getName())) {
                String contributerPluginId = extension.getContributor().getName();
                String id = element.getAttribute("id");
                DashboardCategory cat = new DashboardCategory();
                cat.setName(element.getAttribute("title"));
                String iconPath = element.getAttribute("icon");
                if (iconPath != null) {
                    ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(contributerPluginId,
                            iconPath);
                    cat.setIcon(imageDescriptor);
                }
                String priorityValue = element.getAttribute("priority");
                
                if (priorityValue != null) {
                    try {
                        cat.setPriority(Integer.parseInt(priorityValue));
                    } catch (NumberFormatException e) {
                        log.error(e.getMessage(), e);
                    }
                }
                cat.setShowTitle(Boolean.valueOf(iconPath));
                dashboardCategories.put(id, cat);
            } else if ("wizardLink".equals(element.getName())) {
                String priority = element.getAttribute("priority");
                String wizardId =  element.getAttribute("wizard");
                String label = jsf.getName(wizardId);
                String key = element.getAttribute("id") + ":" + wizardId + ":"
                        + ((priority != null) ? priority : "0") + ":" + element.getAttribute("description") + ":" + label;
                wizardLinks.put(key, element.getAttribute("category"));
            } else if ("customAction".equals(element.getName())) {
                customActions.put(element.getAttribute("id"), element);;
            }
        }

        Set<Entry<String, String>> wizardLinksSet = wizardLinks.entrySet();
        //Fill and sort the wizard links
        for (Entry<String, String> wizardLink : wizardLinksSet) {
            String catID = wizardLink.getValue();
            if (dashboardCategories.containsKey(catID)) {
                DashboardCategory cat = dashboardCategories.get(catID);
                DashboardLink link = new DashboardLink();
                link.setId(wizardLink.getKey().split(":")[0]);
                link.setName(wizardLink.getKey().split(":")[1]);
                link.setDescription(wizardLink.getKey().split(":")[3]);
                link.setTitle(wizardLink.getKey().split(":")[4]);
                String priorityValue = wizardLink.getKey().split(":")[2];
                if (priorityValue != null) {
                    try {
                        link.setPriority(Integer.parseInt(priorityValue));
                    } catch (NumberFormatException e) {
                        log.error(e.getMessage(), e);
                    }
                }
                cat.getWizards().add(link);
                Collections.sort(cat.getWizards(), new Comparator<DashboardLink>() {

                    public int compare(DashboardLink o1, DashboardLink o2) {
                        if (o1.getPriority() == o2.getPriority()) {
                            o1.getId().compareTo(o2.getId());
                        }
                        return o1.getPriority() - o2.getPriority();
                    }
                });
                dashboardCategories.put(catID, cat);
            } else {
                log.warn("Ignoring dashboard contribution link with undefined category");
            }
        }
    }

    /**
     * Getter method for categoryContributions
     * @return categoryContributions
     */
    public static List<String> getCategoryContributions() {
        return categoryContributions;
    }

    /**
     * Get categories list
     * @return Categories list
     */
    public static List<DashboardCategory> getCategories() {
        List<DashboardCategory> categories = new ArrayList(dashboardCategories.values());
        Collections.sort(categories, new Comparator<DashboardCategory>() {

            public int compare(DashboardCategory o1, DashboardCategory o2) {
                if (o1.getPriority() == o2.getPriority()) {
                    o1.getName().compareTo(o2.getName());
                }
                return o1.getPriority() - o2.getPriority();
            }
        });
        return categories;
    }

    /**
     * This method returns json string of wizard links and corresponding wizard categories
     * ex : - 
     * [{"name":"ESB Templates","iconURL":"null","wizards":[{"id":"dashboard.wizardLink.esb.template.project",
     * "name":"org.wso2.developerstudio.wizards.esb.template","priority":"0","description":"Test 1 Description",
     * "title":"Hello World Proxy Template"}]}]
     * 
     * @return json which contains the categories and related wizard links
     */
    public static String getCategoriesJson() {
        List<DashboardCategory> categories = new ArrayList(dashboardCategories.values());
        Collections.sort(categories, new Comparator<DashboardCategory>() {

            public int compare(DashboardCategory o1, DashboardCategory o2) {
                if (o1.getPriority() == o2.getPriority()) {
                    o1.getName().compareTo(o2.getName());
                }
                return o1.getPriority() - o2.getPriority();
            }
        });
        Iterator<DashboardCategory> iterator = categories.iterator();
        String catJson = "[";
        while (iterator.hasNext()) {
            DashboardCategory next = iterator.next();
            catJson += next.toJson();
            if (iterator.hasNext()) {
                catJson += ",";
            }
        }
        return catJson += "]";
    }
}
