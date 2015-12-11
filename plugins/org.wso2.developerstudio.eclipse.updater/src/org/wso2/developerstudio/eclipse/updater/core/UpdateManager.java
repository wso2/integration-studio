/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.updater.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.operations.InstallOperation;
import org.eclipse.equinox.p2.operations.OperationFactory;
import org.eclipse.equinox.p2.operations.ProvisioningJob;
import org.eclipse.equinox.p2.operations.ProvisioningSession;
import org.eclipse.equinox.p2.operations.Update;
import org.eclipse.equinox.p2.operations.UpdateOperation;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.model.EnhancedFeature;

public class UpdateManager {

	private static final String FEATURE_GROUP_IU_ID_SFX = "feature.group"; //$NON-NLS-1$
	private static final String PROP_IS_HIDDEN = "isHidden"; //$NON-NLS-1$
	private static final String PROP_IS_KERNEL_FEATURE = "isKernelFeature"; //$NON-NLS-1$
	private static final String PROP_BUG_FIXES = "bugFixes"; //$NON-NLS-1$
	private static final String PROP_WHAT_IS_NEW = "whatIsNew"; //$NON-NLS-1$
	private static final String UPDATE_PROPERTIES_FILE = "update.properties"; //$NON-NLS-1$
	private static final String ICON_FILE = "icon.png"; //$NON-NLS-1$
	private static final String FILE_PROTOCOL = "file://"; //$NON-NLS-1$
	private static final String FEATURE_JAR_EXTRCT_FOLDER = "extracted"; //$NON-NLS-1$
	private static final String FEATURE_JAR_IU_ID_SFX = "feature.jar"; //$NON-NLS-1$
	private static final String WSO2_FEATURE_PREFIX = "org.wso2"; //$NON-NLS-1$
	private static final String DEVS_UPDATER_TMP = "DevSUpdaterTmp"; //$NON-NLS-1$
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir"; //$NON-NLS-1$

	@Inject
	protected IProvisioningAgentProvider agentProvider;
	protected IProvisioningAgent p2Agent;
	protected ProvisioningSession session;
	
	// Provisioning Operations
	protected UpdateOperation updateOperation;
	protected InstallOperation installOperation;
	
	// Repository Managers
	protected IArtifactRepositoryManager artifactRepoManager;
	protected IMetadataRepositoryManager metadataRepoManager;
	
	// Installed Features
	protected Collection<IInstallableUnit> installedWSO2Features;
	protected Map<String, IInstallableUnit> installedWSO2FeaturesMap;
	
	// maps related to Update Repo and updates
	protected Collection<IInstallableUnit> availableIUsInUpdateRepo;
	protected Map<String, EnhancedFeature> devsFeaturesInUpdateRepo;
	protected Map<String, Update>	availableUpdates;
	protected Update[] selectedUpdates; 
	protected Map<String, EnhancedFeature> updatebleDevSFeatures;
	
	// maps related to Release Repo and availabe Features
	protected Collection<IInstallableUnit> availableIUsInReleaseRepo;
	protected Map<String, EnhancedFeature> devsFeaturesInReleaseRepo;
	protected Map<String, IInstallableUnit> availableNewFeatures;
	protected Map<String, EnhancedFeature> availableDevFeaturesMap;
	protected Collection<IInstallableUnit> selectedFeatures;

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);

	public UpdateOperation getOperation() {
		return updateOperation;
	}

	public static final int NO_UPDATES_FOUND = UpdateOperation.STATUS_NOTHING_TO_UPDATE;
	private static final String NOT_RESOLVED_ERROR = Messages.UpdateManager_13;

	public UpdateManager() throws RuntimeException {
		initProvisioningAgent();
	}

	protected void initProvisioningAgent() throws RuntimeException {
		try {
			// Inject references
			BundleContext bundleContext = FrameworkUtil.getBundle(
					UpdateManager.class).getBundleContext();
			IEclipseContext serviceContext = EclipseContextFactory
					.getServiceContext(bundleContext);
			ContextInjectionFactory.inject(this, serviceContext);
			// get p2 agent for current system(Eclipse instance in this
			// case)
			// the location for the currently running system is null (see
			// docs)
			p2Agent = agentProvider.createAgent(null);
			session = new ProvisioningSession(p2Agent);
			artifactRepoManager = (IArtifactRepositoryManager) p2Agent
					.getService(IArtifactRepositoryManager.class.getName());
			metadataRepoManager = (IMetadataRepositoryManager) p2Agent
					.getService(IMetadataRepositoryManager.class.getName());

		} catch (Exception e) {
			throw new RuntimeException(Messages.UpdateManager_14, e);
		}
	}

	protected Map<String, EnhancedFeature> readFeatureMetadataFromRepo(
			IArtifactRepository artifactRepository, IQueryResult<IInstallableUnit> allAvailableIUs, IProgressMonitor monitor)
			throws ProvisionException, URISyntaxException, IOException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		SubMonitor progress = SubMonitor.convert(monitor,
				Messages.UpdateManager_15, 1);

		String tmpRoot = System.getProperty(JAVA_IO_TMPDIR) + File.separator
				+ DEVS_UPDATER_TMP;

		Collection<IInstallableUnit> wso2features = filterInstallableUnits(
				WSO2_FEATURE_PREFIX, FEATURE_JAR_IU_ID_SFX, allAvailableIUs, progress.newChild(1));

		Map<String, EnhancedFeature> featureMetadataMap = new HashMap<>();

		for (IInstallableUnit iu : wso2features) {
			SubMonitor downloadProgress = SubMonitor.convert(progress,
					Messages.UpdateManager_16, wso2features.size() * 2);
			Collection<IArtifactKey> artifacts = iu.getArtifacts();
			// ideally there should be only one artifact in feature.jar iu
			for (IArtifactKey iArtifactKey : artifacts) {
				IArtifactDescriptor[] artifactDescriptors = artifactRepository
						.getArtifactDescriptors(iArtifactKey);
				File cachedFeatureRoot = new File(tmpRoot, iu.getId()
						+ File.separator + iu.getVersion().toString());
				File cachedFeatureDir = new File(cachedFeatureRoot, FEATURE_JAR_EXTRCT_FOLDER);

				if (cachedFeatureDir.exists() && cachedFeatureDir.isDirectory()) {
					downloadProgress.worked(2);
				} else {
					cachedFeatureRoot.mkdirs();
					File jarFile = new File(cachedFeatureRoot, iu.getId());
					try {
						if (jarFile.exists()) {
							// something is wrong with the file
							// if it is there without the cache dir.
							jarFile.delete();
						}
						FileOutputStream fop = new FileOutputStream(jarFile);
						// jar iu only contains a single artifact. hence [0]
						artifactRepository.getArtifact(artifactDescriptors[0],
								fop, downloadProgress.newChild(1));
						cachedFeatureDir.mkdirs();
						extractJar(jarFile, cachedFeatureDir);
						downloadProgress.worked(1);
					} catch (IOException e) {
						throw new IOException(
								Messages.UpdateManager_17, e);
					}
				}
				EnhancedFeature feature = parseAdditionalFeatureMetadata(iu,
						cachedFeatureDir);
				featureMetadataMap.put(feature.getId(), feature);
			}
		}
		return featureMetadataMap;
	}

	private EnhancedFeature parseAdditionalFeatureMetadata(IInstallableUnit iu,
			File cachedFeatureDir) {
		EnhancedFeature feature = new EnhancedFeature(iu);
		feature.setIconURL(FILE_PROTOCOL + cachedFeatureDir + File.separator + 
				ICON_FILE);
		try {
			File updateProperties = new File(cachedFeatureDir,
					UPDATE_PROPERTIES_FILE);
			Properties prop = new Properties();
			InputStream input = new FileInputStream(updateProperties);
			prop.load(input);
			feature.setWhatIsNew(prop.getProperty(PROP_WHAT_IS_NEW));
			feature.setBugFixes(prop.getProperty(PROP_BUG_FIXES));
			feature.setKernelFeature(Boolean.parseBoolean(prop
					.getProperty(PROP_IS_KERNEL_FEATURE)));
			feature.setHidden(Boolean.parseBoolean(prop
					.getProperty(PROP_IS_HIDDEN)));	
		} catch (Exception e) {
			// ignore - Additional meta-data was not provided in feature.jar
			// log.error(e);
		}
		return feature;
	}

	/**
	 * Extracts a jar file to a given directory.
	 * 
	 * @param jar
	 *            Source jar file.
	 * @param extractpath
	 *            Destination to extract.
	 * 
	 * @throws IOException
	 */
	private void extractJar(File jar, File extractpath) throws IOException {
		ZipFile zipFile = new ZipFile(jar);
		try {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				File entryDestination = new File(extractpath, entry.getName());
				if (entry.isDirectory())
					entryDestination.mkdirs();
				else {
					entryDestination.getParentFile().mkdirs();
					InputStream in = zipFile.getInputStream(entry);
					OutputStream out = new FileOutputStream(entryDestination);
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(in);
					out.close();
				}
			}
		} finally {
			zipFile.close();
		}
	}

	public void checkForAvailableUpdates(IProgressMonitor monitor)
			throws Exception{
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		SubMonitor progress = SubMonitor.convert(monitor,
				Messages.UpdateManager_18, 6);

        // get all available IUs in update repo
		IMetadataRepository metadataRepository = metadataRepoManager
				.loadRepository(getDevStudioUpdateSite(), progress.newChild(1));
		IQuery<IInstallableUnit> allIUQuery = QueryUtil.createIUAnyQuery();
		IQueryResult<IInstallableUnit> allIUQueryResult = metadataRepository.query(allIUQuery,
				progress.newChild(1));
		availableIUsInUpdateRepo = allIUQueryResult.toSet();
		
		// load artifact repo for updates
		IArtifactRepository updateArtifactRepository = artifactRepoManager
				.loadRepository(getDevStudioUpdateSite(), progress.newChild(1));
		
		
		// read metadata of all available features
		devsFeaturesInUpdateRepo = readFeatureMetadataFromRepo(
				updateArtifactRepository, allIUQueryResult,
				progress.newChild(1));

		// get all installed wso2 features
		installedWSO2Features = getInstalledWSO2Features(progress.newChild(1));
		
		installedWSO2FeaturesMap = new HashMap<String, IInstallableUnit>();
		for (IInstallableUnit iInstallableUnit : installedWSO2Features) {
			installedWSO2FeaturesMap.put(iInstallableUnit.getId(), iInstallableUnit);
		}

		if (progress.isCanceled()) {
			throw new OperationCanceledException();
		}

		URI[] repos = new URI[] { getDevStudioUpdateSite() };
		updateOperation = new UpdateOperation(session, installedWSO2Features);
		updateOperation.getProvisioningContext().setArtifactRepositories(
				repos);
		updateOperation.getProvisioningContext().setMetadataRepositories(
				repos);
		IStatus status = updateOperation.resolveModal(progress.newChild(1));
		if (status.getSeverity() == IStatus.CANCEL
				|| progress.isCanceled()) {
			throw new OperationCanceledException();
		}
		if (status.getCode() == UpdateOperation.STATUS_NOTHING_TO_UPDATE) {
			updatebleDevSFeatures = new HashMap<String, EnhancedFeature>();
			log.info(Messages.UpdateManager_19);
		} else if (status.getSeverity() == IStatus.ERROR) {
			log.info(Messages.UpdateManager_20);
		} else {
			setPossibleUpdates(updateOperation.getPossibleUpdates());
		}
	}

	private void setPossibleUpdates(Update[] possibleUpdates) {
		availableUpdates = new HashMap<String, Update>();
		updatebleDevSFeatures = new HashMap<String, EnhancedFeature>();
		for (Update update : possibleUpdates) {
			String id = update.replacement.getId();
			String oldVersion = update.toUpdate.getVersion().toString();
			String newVersion = update.replacement.getVersion().toString();
			EnhancedFeature updatebleFeature = devsFeaturesInUpdateRepo.get(id);
			updatebleFeature.setCurrentVersion(oldVersion);
			updatebleFeature.setVersion(newVersion);
			availableUpdates.put(id, update);
			updatebleDevSFeatures.put(id, updatebleFeature);	
		}
	}

	public void checkForAvailableFeatures(IProgressMonitor monitor)
			throws Exception {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		SubMonitor progress = SubMonitor.convert(monitor,
				Messages.UpdateManager_21, 5);

		// get all available IUs in update repo
		IMetadataRepository metadataRepository = metadataRepoManager
				.loadRepository(getDevStudioReleaseSite(), progress.newChild(1));
		IQuery<IInstallableUnit> allIUQuery = QueryUtil.createIUAnyQuery();
		IQueryResult<IInstallableUnit> allIUQueryResult = metadataRepository
				.query(allIUQuery, progress.newChild(1));
		availableIUsInReleaseRepo = allIUQueryResult.toSet();

		// load artifact repo for updates
		IArtifactRepository updateArtifactRepository = artifactRepoManager
				.loadRepository(getDevStudioReleaseSite(), progress.newChild(1));

		// read metadata of all available features
		devsFeaturesInReleaseRepo = readFeatureMetadataFromRepo(
				updateArtifactRepository, allIUQueryResult,
				progress.newChild(1));

		Collection<IInstallableUnit> filteredIUs = filterInstallableUnits(
				WSO2_FEATURE_PREFIX, FEATURE_GROUP_IU_ID_SFX, allIUQueryResult,
				progress.newChild(1));
		availableNewFeatures = new HashMap<String, IInstallableUnit>();
		availableDevFeaturesMap = new HashMap<String, EnhancedFeature>();
		for (IInstallableUnit iInstallableUnit : filteredIUs) {
			availableNewFeatures
					.put(iInstallableUnit.getId(), iInstallableUnit);
			if (!installedWSO2FeaturesMap.containsKey(iInstallableUnit.getId())) {
				availableDevFeaturesMap
						.put(iInstallableUnit.getId(),
								devsFeaturesInReleaseRepo.get(iInstallableUnit
										.getId()));
			}
		}
	}

	private URI getDevStudioUpdateSite() {
		URI updateSite = null;
		try {
			IPreferenceStore preferenceStore = org.wso2.developerstudio.eclipse.platform.ui.Activator
					.getDefault().getPreferenceStore();
			String url = preferenceStore
					.getString(UpdateCheckerPreferencePage.UPDATE_SITE_URL);
			updateSite = new URI(url);
		} catch (URISyntaxException e) {
			log.error(e);
		}
		return updateSite;
	}

	private URI getDevStudioReleaseSite() {
		URI releaseSite = null;
		try {
			IPreferenceStore preferenceStore = org.wso2.developerstudio.eclipse.platform.ui.Activator
					.getDefault().getPreferenceStore();
			String url = preferenceStore
					.getString(UpdateCheckerPreferencePage.RELESE_SITE_URL);
			releaseSite = new URI(url);
		} catch (URISyntaxException e) {
			log.error(e);
		}
		return releaseSite;
	}

	public IStatus update(IProgressMonitor monitor)
			throws OperationCanceledException {
		monitor.beginTask(Messages.UpdateManager_22, 2);
		ProvisioningJob job = updateOperation
				.getProvisioningJob(new SubProgressMonitor(monitor, 1));
		IStatus status = job.runModal(new SubProgressMonitor(monitor, 1));
		if (status.getSeverity() == IStatus.CANCEL) {
			throw new OperationCanceledException();
		}
		monitor.done();
		return status;
	}

	public Collection<IInstallableUnit> getInstalledWSO2Features(
			IProgressMonitor monitor) throws OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(monitor,
				Messages.UpdateManager_23, 2);

		OperationFactory operationFactory = new OperationFactory();
		IQueryResult<IInstallableUnit> queryResult = operationFactory
				.listInstalledElements(true, progress.newChild(1));
		return filterInstallableUnits(WSO2_FEATURE_PREFIX, FEATURE_GROUP_IU_ID_SFX, queryResult,
				progress.newChild(1));
	}

	protected Collection<IInstallableUnit> filterInstallableUnits(
			String idPrefix, String idSuffix,
			IQueryResult<IInstallableUnit> queryResult, IProgressMonitor monitor)
			throws OperationCanceledException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		Collection<IInstallableUnit> wso2IUs = new ArrayList<IInstallableUnit>();
		Iterator<IInstallableUnit> iterator = queryResult.iterator();
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_24,
				queryResult.toSet().size());
		;
		while (iterator.hasNext()) {
			if (progress.isCanceled()) {
				throw new OperationCanceledException();
			}
			IInstallableUnit iu = iterator.next();
			String versionedID = iu.getId();
			progress.subTask(Messages.UpdateManager_25 + versionedID);
			if (versionedID != null && versionedID.startsWith(idPrefix)
					&& versionedID.endsWith(idSuffix)) {
					wso2IUs.add(iu);
			}
			progress.worked(1);
		}
		return wso2IUs;
	}

	/**
	 * Get the list of all possible updates. This list may include multiple
	 * versions of updates for the same Feature, as well as patches to the
	 * Feature.
	 * 
	 * @return an array of all possible updates
	 */
	public Update[] getPossibleUpdates() throws IllegalStateException {
		if (updateOperation == null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return updateOperation.getPossibleUpdates();
	}
	
	/**
	 * Get the list of all possible updates. This list may include multiple
	 * versions of updates for the same Feature, as well as patches to the
	 * Feature.
	 * 
	 * @return an array of all possible updates
	 */
	public Map<String, EnhancedFeature> getAvailableFeaturesMap() throws IllegalStateException {
		if (availableDevFeaturesMap ==  null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return availableDevFeaturesMap;
	}

	/**
	 * Get the list of latest updates. This list only includes the latest update
	 * available for each feature.
	 * 
	 * @return the latest updates that are chosen from all of the available
	 *         updates
	 */
	public Update[] getLatestUpdates() {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return updateOperation.getSelectedUpdates();
	}

	public String getResolutionDetails() throws IllegalStateException {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return updateOperation.getResolutionDetails();
	}

	public String getResolutionDetails(IInstallableUnit iu)
			throws IllegalStateException {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return updateOperation.getResolutionDetails(iu);
	}

	public boolean hasNothingToUpdate() throws IllegalStateException {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		} else if (getResolutionResult().getCode() == NO_UPDATES_FOUND) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasResolutionErrors() throws IllegalStateException {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		} else if (getResolutionResult().getSeverity() == IStatus.ERROR) {
			return true;
		}
		return false;
	}

	public boolean hasResolutionWarnings() throws IllegalStateException {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		} else if (getResolutionResult().getSeverity() == IStatus.WARNING) {
			return true;
		}
		return false;
	}

	public IStatus getResolutionResult() throws IllegalStateException {
		if (!updateOperation.hasResolved()) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return updateOperation.getResolutionResult();
	}

	public Map<String, EnhancedFeature> getPossibleUpdatesMap()
			throws IllegalStateException {
		if (updatebleDevSFeatures == null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return updatebleDevSFeatures;
	}
	
	public boolean hasPossibleUpdates()
			throws IllegalStateException {
		if (updatebleDevSFeatures == null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return (updatebleDevSFeatures.size() > 0) ? true : false;
	}

	/**
	 * Set selected updates to install.
	 * 
	 * @param selectedFeaturesList selected updates to install.
	 */
	public void setSelectedUpdates(List<EnhancedFeature> selectedFeaturesList) {
		selectedUpdates = new  Update[selectedFeaturesList.size()];
		int count = 0;
		for (EnhancedFeature selectedFeature: selectedFeaturesList) {
			selectedUpdates[count] = availableUpdates.get(selectedFeature.getId());
			count++;
		}
	
	}
	
	/**
	 * Install selected updates in to developer studio.
	 * Note: call {@link #setSelectedUpdates(List) setSelectedUpdates} 
	 * first.
	 *  
	 * @param monitor
	 */
	public void installSelectedUpdates(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor,
				Messages.UpdateManager_26, 2);
		URI[] repos = new URI[] { getDevStudioUpdateSite() };
		session = new ProvisioningSession(p2Agent);
		updateOperation = new UpdateOperation(session);
		updateOperation.getProvisioningContext().setArtifactRepositories(repos);
		updateOperation.getProvisioningContext().setMetadataRepositories(repos);

		updateOperation.setSelectedUpdates(selectedUpdates);
		IStatus status = updateOperation.resolveModal(progress.newChild(1));
		if (status.getSeverity() == IStatus.CANCEL) {
			throw new OperationCanceledException();
		} else if (status.getSeverity() == IStatus.ERROR) {
			String message = status.getChildren()[0].getMessage();
			log.error(Messages.UpdateManager_27 + message);
		} else {
			final ProvisioningJob provisioningJob = updateOperation
					.getProvisioningJob(progress.newChild(1));
			if (provisioningJob != null) {
				provisioningJob.addJobChangeListener(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent arg0) {
						Display.getDefault().syncExec(new Runnable() {
							@Override
							public void run() {
								boolean restart = MessageDialog
										.openQuestion(
												Display.getDefault()
														.getActiveShell(),
												Messages.UpdateManager_28,
												Messages.UpdateManager_29
														+ Messages.UpdateManager_30);
								if (restart) {
									PlatformUI.getWorkbench().restart();
								}
							}
						});
					}
				});
				provisioningJob.schedule();
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						try {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().showView(IProgressConstants.PROGRESS_VIEW_ID);
						} catch (PartInitException e) {
							log.error(e);
						}
					}
				});
			} else {
				log.error(Messages.UpdateManager_31);
			}
		}
	}

	/**
	 * Set the selected new features to install.
	 * 
	 * @param selectedDevSFeatures Features to install.
	 */
	public void setSelectedFeaturesToInstall(
			List<EnhancedFeature> selectedDevSFeatures) {
		this.selectedFeatures = new ArrayList<IInstallableUnit>();
		for (EnhancedFeature devStudioFeature : selectedDevSFeatures) {
			selectedFeatures.add(availableNewFeatures.get(devStudioFeature
					.getId()));
		}
	}

	/**
	 * Install selected features in to developer studio.
	 * Note: call {@link #setSelectedFeaturesToInstall(List) setSelectedFeaturesToInstall} 
	 * first.
	 * 
	 * @param monitor
	 */
	public void installSelectedFeatures(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor,
				Messages.UpdateManager_32, 2);

		URI[] repos = new URI[] { getDevStudioReleaseSite() };
		session = new ProvisioningSession(p2Agent);
		installOperation = new InstallOperation(session, selectedFeatures);
		installOperation.getProvisioningContext()
				.setArtifactRepositories(repos);
		installOperation.getProvisioningContext()
				.setMetadataRepositories(repos);
		IStatus status = installOperation.resolveModal(progress.newChild(1));
		if (status.getSeverity() == IStatus.CANCEL || progress.isCanceled()) {
			throw new OperationCanceledException();
		} else if (status.getSeverity() == IStatus.ERROR) {
			String message = status.getChildren()[0].getMessage();
			log.error(Messages.UpdateManager_33 + message);
		} else {
			ProvisioningJob provisioningJob = installOperation
					.getProvisioningJob(progress.newChild(1));
			if (provisioningJob != null) {
				provisioningJob.addJobChangeListener(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent arg0) {
						Display.getDefault().syncExec(new Runnable() {
							@Override
							public void run() {
								boolean restart = MessageDialog
										.openQuestion(
												Display.getDefault()
														.getActiveShell(),
												Messages.UpdateManager_34,
												Messages.UpdateManager_35
														+ Messages.UpdateManager_36);
								if (restart) {
									PlatformUI.getWorkbench().restart();
								}
							}
						});
					}
				});
				provisioningJob.schedule();
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						try {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().showView(IProgressConstants.PROGRESS_VIEW_ID);
						} catch (PartInitException e) {
							log.error(e);
						}
					}
				});
			} else {
				log.error(Messages.UpdateManager_37);
			}
		}
	}
}
