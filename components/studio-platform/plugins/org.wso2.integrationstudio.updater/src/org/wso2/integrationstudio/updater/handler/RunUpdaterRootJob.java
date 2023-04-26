/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.updater.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.updater.UpdaterPlugin;

public class RunUpdaterRootJob extends Job {

    protected static IIntegrationStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

    private static final String RELEASE_NOTE_URL = "https://product-dist.wso2.com/p2/integration-studio/release-notes/8.2.0";
    private static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    private static final String EMPTY_STRING = "";

    private static String pluginDirectory = getIntegrationStudioRootPath() + File.separator + "plugins";
    private static File pluginDirFile = new File(pluginDirectory);

    public RunUpdaterRootJob(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected IStatus run(IProgressMonitor arg0) {
        checkUpdatesAvailable();
        return Status.OK_STATUS;
    }

    public static void checkUpdatesAvailable() {
        try {
            loadUpdateNotificationPopup();
        } catch (Exception e) {
            log.error("Exception while running updater tool notifier", e);
        }
    }

    private static void loadUpdateNotificationPopup() {
        long localMaxTimestamp = getLocalMaxTimestamp();
        final List<String> releaseNoteItems = new ArrayList<>();
        getReleaseNotes(releaseNoteItems, localMaxTimestamp);
        if (releaseNoteItems.isEmpty()) {
            return;
        }

        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                UpdateNotificationPopUp notification = new UpdateNotificationPopUp(
                        PlatformUI.getWorkbench().getDisplay(), releaseNoteItems);
                notification.setFadingEnabled(false);
                notification.setDelayClose(0L);
                notification.open();
            }
        });
    }

    /**
     * Method of getting IS root path based on the OS type.
     * 
     * @return tooling root path
     */
    private static String getIntegrationStudioRootPath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String toolingRootPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            boolean isRelativeToolingAppExists = false;
            File macOSRelativeToolingApp = null;
            try {
                macOSRelativeToolingApp = new File((new File(".").getCanonicalFile()).getParent().toString() 
                        + File.separator + "Eclipse");
                if (macOSRelativeToolingApp.exists()) {
                    isRelativeToolingAppExists = true;
                }
            } catch (IOException e) {
            }
            if (isRelativeToolingAppExists && macOSRelativeToolingApp != null) {
                toolingRootPath = macOSRelativeToolingApp.getAbsolutePath() + File.separator;
            } else if (new File(TOOLING_PATH_MAC).exists()) {
                toolingRootPath = TOOLING_PATH_MAC + File.separator;
            } else {
                java.nio.file.Path path = Paths.get(EMPTY_STRING);
                toolingRootPath = (path).toAbsolutePath().toString() + File.separator;
            }
        } else {
            java.nio.file.Path path = Paths.get(EMPTY_STRING);
            toolingRootPath = (path).toAbsolutePath().toString() + File.separator;
        }
        return toolingRootPath;
    }

    private static long getLatestTimestampOfPlstform() {
        String platformPlugin = "org.wso2.integrationstudio.docker.distribution";

        return Collections.max(checkLocalPluginTimestamp(platformPlugin, pluginDirFile));
    }

    private static long getLatestTimestampOfESB() {
        String esbPLugin = "org.wso2.integrationstudio.esb.dashboard.templates";

        return Collections.max(checkLocalPluginTimestamp(esbPLugin, pluginDirFile));
    }

    private static long getLatestTimestampOfDSS() {
        String dssPlugin = "org.wso2.integrationstudio.ds.editor";

        return Collections.max(checkLocalPluginTimestamp(dssPlugin, pluginDirFile));
    }

    private static long getLatestTimestampOfBPS() {
        String bpsPlugin = "org.wso2.integrationstudio.bpel.core";

        return Collections.max(checkLocalPluginTimestamp(bpsPlugin, pluginDirFile));
    }

    private static long getLatestTimestampOfServer() {
        String serverPlugin = "org.wso2.integrationstudio.carbonserver44microei40";

        return Collections.max(checkLocalPluginTimestamp(serverPlugin, pluginDirFile));
    }

    private static List<Long> checkLocalPluginTimestamp(String plugin, File pluginDirFile) {
        List<Long> kernelLibraryPluginsTimestampList = new ArrayList<>();

        FilenameFilter fileNameFilter = new WildcardFileFilter(plugin + "*.jar");
        String[] subKernelLibraryPlugins = pluginDirFile.list(fileNameFilter);

        for (String kernelLibraryPlugin : subKernelLibraryPlugins) {
            String[] fileNameSepertor = kernelLibraryPlugin.split("\\.");
            kernelLibraryPluginsTimestampList.add(Long.parseLong(fileNameSepertor[fileNameSepertor.length - 2]));
        }

        return kernelLibraryPluginsTimestampList;
    }

    private static long getLocalMaxTimestamp() {
        List<Long> localTimestampList = new ArrayList<>();
        localTimestampList.add(getLatestTimestampOfPlstform());
        localTimestampList.add(getLatestTimestampOfESB());
        localTimestampList.add(getLatestTimestampOfDSS());
        localTimestampList.add(getLatestTimestampOfServer());

        return Collections.max(localTimestampList);
    }

    private static void getReleaseNotes(List<String> stringArray, long timestamp) {
        try {
            List<Long> relasedTimestampList = new ArrayList<>();
            Document doc = Jsoup.connect(RELEASE_NOTE_URL).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.attr("href").startsWith("release_") && link.attr("href").endsWith(".txt")) {
                    String currentItemTimestamp = StringUtils.substringBetween(link.attr("href"), "release_", ".txt");
                    try {
                        relasedTimestampList.add(Long.parseLong(currentItemTimestamp));
                    } catch (NumberFormatException error) {
                    }
                }
            }

            for (long currentTimestamp : relasedTimestampList) {
                if (currentTimestamp > timestamp) {
                    URL url = new URL(RELEASE_NOTE_URL + "/release_" + Long.toString(currentTimestamp) + ".txt");
                    InputStream is = url.openConnection().getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringArray.add(line);
                    }

                    is.close();
                    reader.close();
                }
            }
        } catch (IOException e) {
            log.error("Error while connecting to " + RELEASE_NOTE_URL, e);
        }
    }
}
