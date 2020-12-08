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
import java.util.Collection;
import java.util.HashMap;
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

	private static final int SUB_MONITOR_INDEX = 2;
	private static final int AVAILABLE_VERSION_LESS = -1;
	private static final int AVAILABLE_VERSION_GREATER = 1;
	private static final String FEATURE_GROUP_APPEND = ".feature.group";
	private static final String ERROR_TITLE = Messages.UpdateMetaFileReaderJob_0;
	private static final String ERROR_MESSAGE = Messages.UpdateMetaFileReaderJob_1;
	private static final String UPDATES_TXT_FILE = "updates.index";
	public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	public static final String folderLoc = System.getProperty(JAVA_IO_TMPDIR) + File.separator + "DevStudioUpdater";
	public static final String fileLoc = folderLoc + File.separator + UPDATES_TXT_FILE;
	private static final int READ_TIMEOUT_MS = 5000;
	private static final int SOCKET_TIMEOUT_MS = 6000;
	private static final String URL_VALIDATOR = "/";
	protected UpdateManager updateManager;
	public int updateCount = 0;

	/**
	 * returns the updateCount when accessed in the job listener Used to update
	 * the UI thread to display the number of available updates to the user
	 * 
	 * @return updateCount
	 */
	public int getUpdateCount() {
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
			return checkIfUpdatesAvailable(monitor);
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
	}

	private IStatus checkIfUpdatesAvailable(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateCheckerJob_1, SUB_MONITOR_INDEX);
		Collection<IInstallableUnit> installedWSO2Features = updateManager
				.getInstalledWSO2Features(progress.newChild(1));
		BufferedReader buffReader = downloadMetaFile();
		// read the meta file
		if (buffReader == null) {
			promptUserError(Messages.UpdateMetaFileReaderJob_3, ERROR_TITLE);
			return Status.CANCEL_STATUS;
		}
		Map<String, String> availaleDevStudioFeatureVerions = new HashMap<String, String>();
		availaleDevStudioFeatureVerions = readMetaDataFiletoMap(buffReader);
		deleteDownloadedTempFile();
		if (availaleDevStudioFeatureVerions.isEmpty()) {
			log.error(Messages.UpdateCheckerJob_4);
			return Status.CANCEL_STATUS;
		}
		for (IInstallableUnit iInstallableUnit : installedWSO2Features) {
			if (availaleDevStudioFeatureVerions.containsKey(iInstallableUnit.getId())) {
				Version availableVersion = generateVersionFromString(
						availaleDevStudioFeatureVerions.get(iInstallableUnit.getId()));
				Version upperLimit = generateUpperLimitforUpdates(iInstallableUnit.getVersion());
				if (availableVersion != null
						&& availableVersion.compareTo(iInstallableUnit.getVersion()) == AVAILABLE_VERSION_GREATER
						&& availableVersion.compareTo(upperLimit) == AVAILABLE_VERSION_LESS) {
					updateCount = updateCount + 1;
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
		return Status.CANCEL_STATUS;
	}

	private Version generateUpperLimitforUpdates(Version version) {
		String installedVersion = version.toString();
		String[] majorMinorUpperLmit = installedVersion.split("\\.");
		int currentMinorVerions = Integer.parseInt(majorMinorUpperLmit[1]);
		int nextMinorVersion = currentMinorVerions + 1;
		Version upperLimit = Version.createOSGi(Integer.parseInt(majorMinorUpperLmit[0]),
				Integer.parseInt(String.valueOf(nextMinorVersion)), Integer.parseInt(majorMinorUpperLmit[2]),
				majorMinorUpperLmit[3]);
		return upperLimit;
	}

	private void deleteDownloadedTempFile() {
		File downloadedMetaFile = new File(fileLoc);
		File downloadedFolderLoc = new File(folderLoc);
		if (downloadedMetaFile.exists()) {
			if (downloadedMetaFile.delete()) {
				log.error("error in deleting temp file " + downloadedMetaFile);
			}
			if (downloadedFolderLoc.exists()) {
				if (downloadedFolderLoc.delete()) {
					log.error("error in deleting temp folder Location " + downloadedFolderLoc);
				}
			}
		}
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

	private HashMap<String, String> readMetaDataFiletoMap(BufferedReader br) {
		Map<String, String> featureMap = new HashMap<String, String>();
			try {
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

	private BufferedReader downloadMetaFile() {
		BufferedReader reader = null;
		File updateFile = new File(fileLoc);
		try {
			// needs to enable once the pref store values are up
			IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
			String url = preferenceStore.getString(PreferenceConstants.UPDATE_SITE_URL);
			if (url == null || url.isEmpty()) {
				url = PreferenceInitializer.DEFAULT_UPDATE_SITE;
			}
			// If user doesn't include a '/' after the url then adds a '/'
			if (!url.endsWith(URL_VALIDATOR)) {
				url = url + URL_VALIDATOR;
			}
			URL link = new URL(url + UPDATES_TXT_FILE);
			FileUtils.copyURLToFile(link, updateFile, SOCKET_TIMEOUT_MS, READ_TIMEOUT_MS);
			reader = new BufferedReader(new FileReader (updateFile));
			
		} catch (IOException e) {
			log.error("error in writing the the content from the downloaded meta data file for updates", e);
		}
		return reader;
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
