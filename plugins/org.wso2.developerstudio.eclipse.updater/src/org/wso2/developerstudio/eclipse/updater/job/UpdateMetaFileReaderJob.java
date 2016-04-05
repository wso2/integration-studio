/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.updater.job;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceConstants;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceInitializer;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;

/**
 * This class defines the job in updater checker to read possible updates
 * availability from the meta file.
 *
 */
public class UpdateMetaFileReaderJob extends Job {

	private static final int AVAILABLE_VERSION_GREATER = 1;
	private static final String FEATURE_GROUP_APPEND = ".feature.group";
	private static final String ERROR_TITLE = "Automatic Updater error";
	private static final String ERROR_MESSAGE = "Error in retrieving available updates automatically";
	private static final String UPDATES_TXT_FILE = "updates.txt";
	public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	public static final String folderLoc = System.getProperty(JAVA_IO_TMPDIR) + File.separator + "DevStudioUpdater";
	public static final String fileLoc = folderLoc + File.separator + UPDATES_TXT_FILE;
	private static final int TIME_OUT_MS = 1000;
	protected UpdateManager updateManager;
	public static int updateCount = 0;

	public static int getUpdateCount() {
		return updateCount;
	}

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	public UpdateMetaFileReaderJob(UpdateManager updateManager) {
		super(Messages.UpdateCheckerJob_0);
		this.updateManager = updateManager;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateCheckerJob_1, 2);
			Collection<IInstallableUnit> installedWSO2Features = updateManager
					.getInstalledWSO2Features(progress.newChild(1));
			// read the meta file
			downloadMetaFile();
			Map<String, String> availaleDevStudioFeatureVerions = new HashMap<String, String>();
			availaleDevStudioFeatureVerions = readMetaDataFiletoMap();
			if (availaleDevStudioFeatureVerions.isEmpty()) {
				log.error(Messages.UpdateCheckerJob_4);
				return Status.CANCEL_STATUS;
			}
			for (IInstallableUnit iInstallableUnit : installedWSO2Features) {
				if (availaleDevStudioFeatureVerions.containsKey(iInstallableUnit.getId())) {
					Version availableVersion = generateVersionFromString(
							availaleDevStudioFeatureVerions.get(iInstallableUnit.getId()));
					if (availableVersion != null
							&& availableVersion.compareTo(iInstallableUnit.getVersion()) == AVAILABLE_VERSION_GREATER) {
						updateCount++;
					} else if (availableVersion == null) {
						log.error(Messages.UpdateCheckerJob_4);
						promptUserError(ERROR_MESSAGE, ERROR_TITLE);
						return Status.CANCEL_STATUS;
					}
				}
			}
			if (updateCount > 0) {
				return Status.OK_STATUS; // OK if there are updates
			}
		} catch (Exception e) {
			/**
			 * We are catching the run time exception here since a runtime
			 * exception here should not prevent the user from running developer
			 * studio instead we are popping up an error dialog and let the user
			 * proceed.
			 */
			log.error(Messages.UpdateCheckerJob_4, e);
			promptUserError(ERROR_MESSAGE, ERROR_TITLE);
			return Status.CANCEL_STATUS;
		}
		return Status.CANCEL_STATUS;// if no exceptions and no updates to be
									// installed return cancel
	}

	/**
	 * version would come as 4.0.0-201512221344 we need to create the
	 * installable unit version object from the version string
	 * 
	 * @param versionString
	 */
	private Version generateVersionFromString(String versionString) {
		String[] minorMajorNumbers = versionString.split("\\."); // . is \\. in
		Version availableVersion = Version.createOSGi(Integer.parseInt(minorMajorNumbers[0]),
				Integer.parseInt(minorMajorNumbers[1]), Integer.parseInt(minorMajorNumbers[2]), minorMajorNumbers[3]);
		return availableVersion;
	}

	private HashMap<String, String> readMetaDataFiletoMap() {
		Map<String, String> featureMap = new HashMap<String, String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileLoc))) {
			for (String line; (line = br.readLine()) != null;) {
				if (line.contains(",")) {
					String[] feature = line.split(",");
					featureMap.put(feature[0] + FEATURE_GROUP_APPEND, feature[1]);
				}
			}
		} catch (IOException e) {
			log.error(Messages.UpdateCheckerJob_3, e);
		}
		return (HashMap<String, String>) featureMap;
	}

	private void downloadMetaFile() {
		try {
			File updateFile = new File(fileLoc);
			// needs to enable once the pref store values are up
			IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
			String url = preferenceStore.getString(PreferenceConstants.UPDATE_SITE_URL);
			if (url == null || url.isEmpty()) {
				url = PreferenceInitializer.DEFAULT_UPDATE_SITE;
			}
			URL link = new URL(url + UPDATES_TXT_FILE);
			FileUtils.copyURLToFile(link, updateFile, TIME_OUT_MS, TIME_OUT_MS);
		} catch (IOException e) {
			log.error("error in writing the the content from the downloaded meta data file for updates", e);
		}
	}

	public static void promptUserError(final String message, final String title) {

		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openError(Display.getDefault().getActiveShell(), title, message);
			}
		});
	}
}
