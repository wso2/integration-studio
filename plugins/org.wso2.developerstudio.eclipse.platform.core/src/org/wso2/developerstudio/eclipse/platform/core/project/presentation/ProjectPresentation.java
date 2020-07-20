/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.platform.core.project.presentation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.resources.nested.HideFolderWhenProjectIsShownAsNested;
import org.eclipse.ui.internal.navigator.resources.nested.HideTopLevelProjectIfNested;
import org.eclipse.ui.internal.navigator.resources.nested.NestedProjectsContentProvider;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.ICommonFilterDescriptor;
import org.eclipse.ui.navigator.INavigatorFilterService;

public class ProjectPresentation {
    private static final Path IS_PROPERTIES_PATH = Paths.get(
            ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString(), ".metadata",
            "integration-studio.properties");
    private static final String HIERACHICAL_PRESENTATION = "hierarchical.project.presentation";

    public static void setHierarchicalProjectPresentation() {

        try (InputStream propertiesFileStream = Files.newInputStream(IS_PROPERTIES_PATH)) {
            if (propertiesFileStream != null) {
                Properties existingProperties = new Properties();
                existingProperties.load(propertiesFileStream);
                String hierarchicalPresentationProperty = existingProperties.getProperty(HIERACHICAL_PRESENTATION);
                if (hierarchicalPresentationProperty != null) {
                    return;
                } else {
                    setHierarchicalLevelForProjectPresentation();
                    setProperty(existingProperties);
                    return;
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            // ignore the error log until the .properties file is available
        }
        setHierarchicalLevelForProjectPresentation();
        setProperty(null);
    }

    private static void setHierarchicalLevelForProjectPresentation() {
        try {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            IViewPart part = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
            if (part instanceof CommonNavigator) {
                CommonNavigator navigator = (CommonNavigator) part;
                navigator.getNavigatorContentService().getActivationService()
                        .activateExtensions(new String[] { NestedProjectsContentProvider.EXTENSION_ID }, false);
                ISelection initialSelection = navigator.getCommonViewer().getSelection();
                INavigatorFilterService filterService = navigator.getNavigatorContentService().getFilterService();
                Set<String> filters = new HashSet<>();
                for (ICommonFilterDescriptor desc : filterService.getVisibleFilterDescriptors()) {
                    if (filterService.isActive(desc.getId())) {
                        filters.add(desc.getId());
                    }
                }

                navigator.getNavigatorContentService().getActivationService()
                        .activateExtensions(new String[] { NestedProjectsContentProvider.EXTENSION_ID }, false);
                filters.add(HideTopLevelProjectIfNested.EXTENSION_ID);
                filters.add(HideFolderWhenProjectIsShownAsNested.EXTENTSION_ID);

                filterService.activateFilterIdsAndUpdateViewer(filters.toArray(new String[filters.size()]));
                navigator.getNavigatorContentService().getActivationService().persistExtensionActivations();
                navigator.getCommonViewer().refresh();
                navigator.getCommonViewer().setSelection(initialSelection);
            }
        } catch (Exception e) {
            // ignore
        }
    }

    private static void setProperty(Properties properties) {
        if (properties == null) {
            properties = new Properties();
        }
        try (OutputStream outputStream = new FileOutputStream(IS_PROPERTIES_PATH.toString())) {
            properties.setProperty(HIERACHICAL_PRESENTATION, "true");
            properties.store(outputStream, null);
        } catch (IOException e) {
            // ignore
        }
    }
}
