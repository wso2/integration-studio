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
package org.wso2.developerstudio.eclipse.updater.handler;

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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;

public class RunUpdaterRootJob extends Job {

    protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

    private static final String KERNEL_P2_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/kernel/updates";
    private static final String PLATFORM_P2_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/platform-bundles/updates/7.0.0";
    private static final String ESB_P2_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/esb-tools/updates/7.0.0";
    private static final String DSS_P2_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/dss-tools/updates";
    private static final String BPS_P2_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/bps-tools/updates/7.0.0";
    private static final String EI_P2_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/ei-tools/updates/7.0.0";
    private static final String RELEASE_NOTE_URL = "http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/release-notes";
    
    // testing URLs
//    private static final String KERNEL_P2_URL = "https://integrationstudiotooling.000webhostapp.com/dist/kernel";
//    private static final String PLATFORM_P2_URL = "https://integrationstudiotooling.000webhostapp.com/dist/platform-bundles";
//    private static final String ESB_P2_URL = "https://integrationstudiotooling.000webhostapp.com/dist/esb-tools";
//    private static final String DSS_P2_URL = "https://integrationstudiotooling.000webhostapp.com/dist/dss-tools";
//    private static final String BPS_P2_URL = "https://integrationstudiotooling.000webhostapp.com/dist/bps-tools";
//    private static final String EI_P2_URL = "https://integrationstudiotooling.000webhostapp.com/dist/ei-tools";
//    private static final String RELEASE_NOTE_URL = "https://integrationstudiotooling.000webhostapp.com/dist/release-notes";
    
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
            if (checkUpdateAvailability()) {
                loadUpdateNotificationPopup();
            }
        } catch(Exception e) {
            log.error("Exception while running updater tool process", e);
        }
    }

    private static boolean checkUpdateAvailability() {
        // check kernel timestamps
        long hostedKernelTimestamp = maximumTimestampInGivenURL(KERNEL_P2_URL);
        long localKernelTimestamp = getLatestTimestampOfKernel();
        if (hostedKernelTimestamp > localKernelTimestamp) {
            return true;
        }

        // check platform timestamps
        long hostedPlatformTimestamp = maximumTimestampInGivenURL(PLATFORM_P2_URL);
        long localPlatformTimestamp = getLatestTimestampOfPlstform();
        if (hostedPlatformTimestamp > localPlatformTimestamp) {
            return true;
        }

        // check ESB timestamps
        long hostedESBTimestamp = maximumTimestampInGivenURL(ESB_P2_URL);
        long localESBTimestamp = getLatestTimestampOfESB();
        if (hostedESBTimestamp > localESBTimestamp) {
            return true;
        }

        // check DSS timestamps
        long hostedDSSTimestamp = maximumTimestampInGivenURL(DSS_P2_URL);
        long localDSSTimestamp = getLatestTimestampOfDSS();
        if (hostedDSSTimestamp > localDSSTimestamp) {
            return true;
        }

        // check BPS timestamps
        long hostedBPSTimestamp = maximumTimestampInGivenURL(BPS_P2_URL);
        long localBPSTimestamp = getLatestTimestampOfBPS();
        if (hostedBPSTimestamp > localBPSTimestamp) {
            return true;
        }

        // check EI timestamps
        long hostedEITimestamp = maximumTimestampInGivenURL(EI_P2_URL);
        long localEIimestamp = getLatestTimestampOfEI();
        if (hostedEITimestamp > localEIimestamp) {
            return true;
        }

        return false;
    }

    private static void loadUpdateNotificationPopup() {
        long localMaxTimestamp = getLocalMaxTimestamp();
        final List<String> releaseNoteItems = new ArrayList<>();
        getReleaseNotes(releaseNoteItems, localMaxTimestamp);

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

    private static long maximumTimestampInGivenURL(String url) {
        long timestamp = 0;
        try {
            List<Long> timestampList = new ArrayList<>();
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.attr("href").endsWith("/")) {
                    String[] dirNameSeperator = link.attr("href").split("\\.");
                    if (dirNameSeperator.length > 1) {
                        String timestampWithSlash = dirNameSeperator[dirNameSeperator.length - 1];
                        String[] timestampWithDash = timestampWithSlash.split("-");
                        if (timestampWithDash.length > 1) {
                            timestampWithSlash = timestampWithDash[1];
                        } else {
                            timestampWithSlash = timestampWithDash[0];
                        }

                        try {
                            timestampList.add(
                                    Long.parseLong(timestampWithSlash.substring(0, timestampWithSlash.length() - 1)));
                        } catch (NumberFormatException error) {
                        }
                    }
                }
            }

            if (timestampList.size() > 0) {
                timestamp = Collections.max(timestampList);
            }
        } catch (IOException e) {
            log.error("Error while connecting to " + url, e);
        }

        return timestamp;
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
            File macOSEIToolingAppFile = new File(TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
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

    private static long getLatestTimestampOfKernel() {
        List<Long> kernelPluginsTimestampList = new ArrayList<>();
        String[] kernelPlugins = { "org.wso2.developerstudio.eclipse.kernel.libraries",
                "org.wso2.developerstudio.eclipse.logging", "org.wso2.developerstudio.eclipse.maven",
                "org.wso2.developerstudio.eclipse.platform.core", "org.wso2.developerstudio.eclipse.platform.ui",
                "org.wso2.developerstudio.eclipse.updater", "org.wso2.developerstudio.eclipse.utils",
                "org.wso2.developerstudio.eclipse.wso2plugin.template.manager" };

        for (String plugin : kernelPlugins) {
            List<Long> currentPluginTimestamp = checkLocalPluginTimestamp(plugin, pluginDirFile);
            if (currentPluginTimestamp.size() > 0) {
                kernelPluginsTimestampList.add(Collections.max(currentPluginTimestamp));
            }
        }

        return Collections.max(kernelPluginsTimestampList);
    }

    private static long getLatestTimestampOfPlstform() {
        String platformPLugin = "org.wso2.developerstudio.eclipse.docker.distribution";

        return Collections.max(checkLocalPluginTimestamp(platformPLugin, pluginDirFile));
    }

    private static long getLatestTimestampOfESB() {
        String esbPLugin = "org.wso2.developerstudio.eclipse.esb.dashboard.templates";

        return Collections.max(checkLocalPluginTimestamp(esbPLugin, pluginDirFile));
    }

    private static long getLatestTimestampOfDSS() {
        String esbPLugin = "org.wso2.developerstudio.eclipse.ds.editor";

        return Collections.max(checkLocalPluginTimestamp(esbPLugin, pluginDirFile));
    }

    private static long getLatestTimestampOfEI() {
        String esbPLugin = "org.wso2.developerstudio.eclipse.ei.project";

        return Collections.max(checkLocalPluginTimestamp(esbPLugin, pluginDirFile));
    }

    private static long getLatestTimestampOfBPS() {
        String esbPLugin = "org.wso2.developerstudio.eclipse.bpel.core";

        return Collections.max(checkLocalPluginTimestamp(esbPLugin, pluginDirFile));
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
        localTimestampList.add(getLatestTimestampOfKernel());
        localTimestampList.add(getLatestTimestampOfPlstform());
        localTimestampList.add(getLatestTimestampOfESB());
        localTimestampList.add(getLatestTimestampOfDSS());
        localTimestampList.add(getLatestTimestampOfBPS());
        localTimestampList.add(getLatestTimestampOfEI());
        
        return Collections.max(localTimestampList);
    }
    
    private static void getReleaseNotes(List<String> stringArray, long timestamp) {
        try {
            List<Long> relasedTimestampList = new ArrayList<>();
            Document doc = Jsoup.connect(RELEASE_NOTE_URL).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.attr("href").startsWith("release_") && link.attr("href").endsWith(".txt")) {
                    String currentItemTimestamp = StringUtils.substringBetween(link.attr("href"), "release_", ".txt");;
                    try {
                        relasedTimestampList.add(Long.parseLong(currentItemTimestamp));
                    } catch (NumberFormatException error) {
                    }
                }
            }

            for (long currentTimestamp : relasedTimestampList) {
                if (currentTimestamp > timestamp) {
                    URL url = new URL(RELEASE_NOTE_URL + "/release_" + Long.toString(currentTimestamp) + ".txt");
                    InputStream is = url.openStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    while (reader.ready()) {
                        stringArray.add(reader.readLine());
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
