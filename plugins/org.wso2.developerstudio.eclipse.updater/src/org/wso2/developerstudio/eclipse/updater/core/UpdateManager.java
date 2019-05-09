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
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
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
import org.eclipse.equinox.p2.metadata.Version;
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
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceConstants;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceInitializer;
import org.wso2.developerstudio.eclipse.updater.Messages;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.job.UpdateMetaFileReaderJob;
import org.wso2.developerstudio.eclipse.updater.model.EnhancedFeature;

public class UpdateManager {

	private static final int LESS_THAN = -1;
	private static final String FEATURE_GROUP_IU_ID_SFX = "feature.group"; //$NON-NLS-1$
	private static final String PROP_IS_HIDDEN = "isHidden"; //$NON-NLS-1$
	private static final String PROP_IS_KERNEL_FEATURE = "isKernelFeature"; //$NON-NLS-1$
	private static final String PROP_BUG_FIXES = "bugFixes"; //$NON-NLS-1$
	private static final String CHILD_FEATURES = "children"; //$NON-NLS-1$
	private static final String PROP_WHAT_IS_NEW = "whatIsNew"; //$NON-NLS-1$
	private static final String UPDATE_PROPERTIES_FILE = "update.properties"; //$NON-NLS-1$
	private static final String ICON_FILE = "icon.png"; //$NON-NLS-1$
	private static final String FILE_PROTOCOL = "file://"; //$NON-NLS-1$
	private static final String FEATURE_JAR_EXTRCT_FOLDER = "extracted"; //$NON-NLS-1$
	private static final String FEATURE_JAR_IU_ID_SFX = "feature.jar"; //$NON-NLS-1$
	private static final String WSO2_FEATURE_PREFIX = "org.wso2"; //$NON-NLS-1$
	private static final String DEVS_UPDATER_TMP = "DevSUpdaterTmp"; //$NON-NLS-1$
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir"; //$NON-NLS-1$
	private static final String NOT_RESOLVED_ERROR = Messages.UpdateManager_13;

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
	protected Map<String, IInstallableUnit> installedWSO2FeaturesMap;

	// lists and maps related to Update Repository and updates
	protected Map<String, Update> availableUpdates;
	protected Update[] selectedUpdates;
	protected Map<String, EnhancedFeature> featuresWithPossibleUpdates;

	// lists and maps related to Release Repository and available Features
	protected Map<String, IInstallableUnit> allAvailableFeatures;
	protected Map<String, EnhancedFeature> availableNewFeatures;
	protected Map<String, EnhancedFeature> unsortedAvailableNewFeatures;
	protected Collection<IInstallableUnit> selectedFeatures;

	protected static IDeveloperStudioLog log = Logger.getLog(UpdaterPlugin.PLUGIN_ID);

	public UpdateManager() throws RuntimeException {
		initProvisioningAgent();
	}

	protected void initProvisioningAgent() throws RuntimeException {
		try {
			// Inject references
			BundleContext bundleContext = FrameworkUtil.getBundle(UpdateManager.class).getBundleContext();
			IEclipseContext serviceContext = EclipseContextFactory.getServiceContext(bundleContext);
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

	/**
	 * Finds available WSO2 features in current profile and search for updates
	 * to them in WSO2 p2 repository for updates.
	 * 
	 * @param monitor
	 * @throws Exception
	 */
	public void checkForAvailableUpdates(IProgressMonitor monitor) throws Exception {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_18, 6);

		// get all available IUs in update repository
		IMetadataRepository metadataRepo = null;
		try {
			metadataRepo = metadataRepoManager.loadRepository(getDevStudioUpdateSite(), progress.newChild(1));
		} catch (ProvisionException e) {
			UpdateMetaFileReaderJob.promptUserError(
					"The P2 Does not existed at the given location, please set the update/releases P2 for Integration Studio in the Preference Store",
					"P2 Repository Error");
			throw e;
		}
		IQuery<IInstallableUnit> allIUQuery = QueryUtil.createIUAnyQuery();
		IQueryResult<IInstallableUnit> allIUQueryResult = metadataRepo.query(allIUQuery, progress.newChild(1));

		// read artifact repository for updates
		IArtifactRepository artifactRepo = artifactRepoManager.loadRepository(getDevStudioUpdateSite(),
				progress.newChild(1));

		// read meta-data of all available features
		Map<String, EnhancedFeature> unsortedMap = loadWSO2FeaturesInRepo(artifactRepo, allIUQueryResult,
				progress.newChild(1));
		// sort the map in alphabetical order
		Map<String, EnhancedFeature> allFeaturesInUpdateRepo = new TreeMap<String, EnhancedFeature>(unsortedMap);
		// get all installed wso2 features
		Collection<IInstallableUnit> installedWSO2Features = getInstalledWSO2Features(progress.newChild(1));

		installedWSO2FeaturesMap = new HashMap<String, IInstallableUnit>();
		for (IInstallableUnit iInstallableUnit : installedWSO2Features) {
			installedWSO2FeaturesMap.put(iInstallableUnit.getId(), iInstallableUnit);
		}

		if (progress.isCanceled()) {
			throw new OperationCanceledException();
		}

		URI[] repos = new URI[] { getDevStudioUpdateSite() };
		updateOperation = new UpdateOperation(session, installedWSO2Features);
		updateOperation.getProvisioningContext().setArtifactRepositories(repos);
		updateOperation.getProvisioningContext().setMetadataRepositories(repos);

		// resolve update operation
		IStatus status = updateOperation.resolveModal(progress.newChild(1));
		// user cancelled the job while resolving
		if (status.getSeverity() == IStatus.CANCEL || progress.isCanceled()) {
			throw new OperationCanceledException();
		}
		// there is nothing to update
		if (status.getCode() == UpdateOperation.STATUS_NOTHING_TO_UPDATE) {
			featuresWithPossibleUpdates = new HashMap<String, EnhancedFeature>();
			log.info(Messages.UpdateManager_19);
		} else if (status.getSeverity() == IStatus.ERROR) { // resolution errors
			// something wrong with the updates
			log.info(Messages.UpdateManager_20);
		} else {
			// good to proceed installing updates
			setPossibleUpdates(updateOperation.getPossibleUpdates(), allFeaturesInUpdateRepo);
		}
		// sort the available updates in alphabetical order

	}

	/**
	 * Searches available features in WSO2 p2 repository for the current version
	 * of Developer Studio and filters new features that can be installed.
	 * 
	 * @param monitor
	 * @throws Exception
	 */
	public void checkForAvailableFeatures(IProgressMonitor monitor) throws Exception {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_21, 5);

		// get all available IUs in release repository
		IMetadataRepository metadataRepository = null;
		try {
			metadataRepository = metadataRepoManager.loadRepository(getDevStudioReleaseSite(), progress.newChild(1));
		} catch (ProvisionException e) {
			UpdateMetaFileReaderJob.promptUserError(
					"The P2 Does not existed at the given location, please set the update/releases P2 for Integration Studio in the Preference Store",
					"P2 Repository Error");
			throw e;
		}
		IQuery<IInstallableUnit> allIUQuery = QueryUtil.createIUAnyQuery();
		IQueryResult<IInstallableUnit> allIUQueryResult = metadataRepository.query(allIUQuery, progress.newChild(1));
		// load artifact repository for releases
		IArtifactRepository artifactRepository = artifactRepoManager.loadRepository(getDevStudioReleaseSite(),
				progress.newChild(1));

		// read meta-data of all available features
		Map<String, EnhancedFeature> allFeaturesInReleaseRepo = loadWSO2FeaturesInRepo(artifactRepository,
				allIUQueryResult, progress.newChild(1));


		Collection<IInstallableUnit> filteredIUs = filterInstallableUnits(WSO2_FEATURE_PREFIX, FEATURE_GROUP_IU_ID_SFX,
				allIUQueryResult, progress.newChild(1));
		allAvailableFeatures = new HashMap<String, IInstallableUnit>();
		unsortedAvailableNewFeatures = new HashMap<String, EnhancedFeature>();
		for (IInstallableUnit iInstallableUnit : filteredIUs) {
			allAvailableFeatures.put(iInstallableUnit.getId(), iInstallableUnit);
			if (!installedWSO2FeaturesMap.containsKey(iInstallableUnit.getId())) {
				unsortedAvailableNewFeatures.put(iInstallableUnit.getId(),
						allFeaturesInReleaseRepo.get(iInstallableUnit.getId()));
			} else {
				Version versionInstalled = installedWSO2FeaturesMap.get(iInstallableUnit.getId()).getVersion();
				// if the version we have is greater than the installed version
				// view it in the available feature list
				if (versionInstalled != null && (iInstallableUnit.getVersion().compareTo(versionInstalled) == 1)) {
					unsortedAvailableNewFeatures.put(iInstallableUnit.getId(),
							allFeaturesInReleaseRepo.get(iInstallableUnit.getId()));
				}
			}
		}
		// sort the available new features according to alphabetical order
		availableNewFeatures = new TreeMap<String, EnhancedFeature>(unsortedAvailableNewFeatures);
	}

	/**
	 * Set selected updates to install.
	 * 
	 * @param selectedFeaturesList
	 *            selected updates to install.
	 */
	public void setSelectedUpdates(List<EnhancedFeature> selectedFeaturesList) {
		selectedUpdates = new Update[selectedFeaturesList.size()];
		int count = 0;
		for (EnhancedFeature selectedFeature : selectedFeaturesList) {
			selectedUpdates[count] = availableUpdates.get(selectedFeature.getId());
			count++;
		}

	}

	/**
	 * Install selected updates in to developer studio. Note: call
	 * {@link #setSelectedUpdates(List) setSelectedUpdates} first.
	 * 
	 * @param monitor
	 */
	public void installSelectedUpdates(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_26, 2);
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
			UpdateMetaFileReaderJob.promptUserError(message, Messages.UpdateManager_27);
			log.error(Messages.UpdateManager_27 + message);
		} else {
			final ProvisioningJob provisioningJob = updateOperation.getProvisioningJob(progress.newChild(1));
			if (provisioningJob != null) {
				provisioningJob.addJobChangeListener(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent arg0) {
						Display.getDefault().syncExec(new Runnable() {
							@Override
							public void run() {
								boolean restart = MessageDialog.openQuestion(Display.getDefault().getActiveShell(),
										Messages.UpdateManager_28,
										Messages.UpdateManager_29 + Messages.UpdateManager_30);
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
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
									.showView(IProgressConstants.PROGRESS_VIEW_ID);
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
	 * @param selectedDevSFeatures
	 *            Features to install.
	 */
	public void setSelectedFeaturesToInstall(List<EnhancedFeature> selectedDevSFeatures) {
		this.selectedFeatures = new ArrayList<IInstallableUnit>();
		for (EnhancedFeature devStudioFeature : selectedDevSFeatures) {
			selectedFeatures.add(allAvailableFeatures.get(devStudioFeature.getId()));
			if (devStudioFeature.getChildFeatures() != null && devStudioFeature.getChildFeatures().length != 0) {
				String[] childFeaturesToInstall = devStudioFeature.getChildFeatures();
				for (String childFeature : childFeaturesToInstall) {// set all
																	// children
																	// of
																	// selected
																	// features
					String featureID = childFeature + ".feature.group";
					selectedFeatures.add(allAvailableFeatures.get(featureID));
				}
			}
		}
	}

	/**
	 * Install selected features in to developer studio. Note: call
	 * {@link #setSelectedFeaturesToInstall(List) setSelectedFeaturesToInstall}
	 * first.
	 * 
	 * @param monitor
	 */
	public void installSelectedFeatures(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_32, 2);

		URI[] repos = new URI[] { getDevStudioReleaseSite() };
		session = new ProvisioningSession(p2Agent);
		installOperation = new InstallOperation(session, selectedFeatures);
		installOperation.getProvisioningContext().setArtifactRepositories(repos);
		installOperation.getProvisioningContext().setMetadataRepositories(repos);
		IStatus status = installOperation.resolveModal(progress.newChild(1));
		if (status.getSeverity() == IStatus.CANCEL || progress.isCanceled()) {
			throw new OperationCanceledException();
		} else if (status.getSeverity() == IStatus.ERROR) {
			String message = status.getChildren()[0].getMessage();
			log.error(Messages.UpdateManager_33 + message);
			UpdateMetaFileReaderJob.promptUserError(message, Messages.UpdateManager_33);
		} else {
			ProvisioningJob provisioningJob = installOperation.getProvisioningJob(progress.newChild(1));
			if (provisioningJob != null) {
				provisioningJob.addJobChangeListener(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent arg0) {
						Display.getDefault().syncExec(new Runnable() {
							@Override
							public void run() {
								boolean restart = MessageDialog.openQuestion(Display.getDefault().getActiveShell(),
										Messages.UpdateManager_34,
										Messages.UpdateManager_35 + Messages.UpdateManager_36);
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
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
									.showView(IProgressConstants.PROGRESS_VIEW_ID);
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

	public Map<String, EnhancedFeature> getPossibleUpdatesMap() throws IllegalStateException {
		if (featuresWithPossibleUpdates == null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return featuresWithPossibleUpdates;
	}

	public boolean hasPossibleUpdates() throws IllegalStateException {
		if (featuresWithPossibleUpdates == null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return (featuresWithPossibleUpdates.size() > 0) ? true : false;
	}

	public Map<String, EnhancedFeature> getAvailableFeaturesMap() throws IllegalStateException {
		if (availableNewFeatures == null) {
			throw new IllegalStateException(NOT_RESOLVED_ERROR);
		}
		return availableNewFeatures;
	}

	private Map<String, EnhancedFeature> loadWSO2FeaturesInRepo(IArtifactRepository artifactRepository,
			IQueryResult<IInstallableUnit> allAvailableIUs, IProgressMonitor monitor)
			throws ProvisionException, URISyntaxException, IOException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_15, 10);

		String tmpRoot = System.getProperty(JAVA_IO_TMPDIR) + File.separator + DEVS_UPDATER_TMP;

		Collection<IInstallableUnit> wso2FeatureJars = filterInstallableUnits(WSO2_FEATURE_PREFIX,
				FEATURE_JAR_IU_ID_SFX, allAvailableIUs, progress.newChild(1));

		Map<String, EnhancedFeature> loadedFeatureMap = new HashMap<>();

		for (IInstallableUnit iu : wso2FeatureJars) {
			SubMonitor downloadProgress = SubMonitor.convert(progress, Messages.UpdateManager_16,
					wso2FeatureJars.size() * 2);
			Collection<IArtifactKey> artifacts = iu.getArtifacts();
			// ideally there should be only one artifact in a feature.jar iu
			for (IArtifactKey iArtifactKey : artifacts) {
				IArtifactDescriptor[] artifactDescriptors = artifactRepository.getArtifactDescriptors(iArtifactKey);
				File featureCacheRoot = new File(tmpRoot, iu.getId() + File.separator + iu.getVersion().toString());
				File cachedFeatureDir = new File(featureCacheRoot, FEATURE_JAR_EXTRCT_FOLDER);

				if (cachedFeatureDir.exists() && cachedFeatureDir.isDirectory()) {
					downloadProgress.worked(2);
				} else {
					featureCacheRoot.mkdirs();
					File jarFile = new File(featureCacheRoot, iu.getId());
					try {
						if (jarFile.exists()) {
							// something is wrong with the file
							// if it is there without the cache dir.
							jarFile.delete();
						}
						FileOutputStream fop = new FileOutputStream(jarFile);
						// jar iu only contains a single artifact. hence [0]
						artifactRepository.getArtifact(artifactDescriptors[0], fop, downloadProgress.newChild(1));
						cachedFeatureDir.mkdirs();
						extractJar(jarFile, cachedFeatureDir);
						downloadProgress.worked(1);
					} catch (IOException e) {
						throw new IOException(Messages.UpdateManager_17, e);
					}
				}
				EnhancedFeature feature = readEnhancedMetadata(iu, cachedFeatureDir);
				loadedFeatureMap.put(feature.getId(), feature);
			}
		}
		return loadedFeatureMap;
	}

	private EnhancedFeature readEnhancedMetadata(IInstallableUnit iu, File cachedFeatureDir) {
		EnhancedFeature feature = new EnhancedFeature(iu);
		feature.setIconURL(FILE_PROTOCOL + cachedFeatureDir + File.separator + ICON_FILE);
		try {
			File updateProperties = new File(cachedFeatureDir, UPDATE_PROPERTIES_FILE);
			if (updateProperties.exists()) {
				Properties prop = new Properties();
				InputStream input = new FileInputStream(updateProperties);
				prop.load(input);
				feature.setWhatIsNew(prop.getProperty(PROP_WHAT_IS_NEW));
				feature.setBugFixes(prop.getProperty(PROP_BUG_FIXES));
				feature.setKernelFeature(Boolean.parseBoolean(prop.getProperty(PROP_IS_KERNEL_FEATURE)));
				feature.setHidden(Boolean.parseBoolean(prop.getProperty(PROP_IS_HIDDEN)));
				String childrenStr = prop.getProperty(CHILD_FEATURES);
				if (childrenStr != null) {
					feature.setChildFeatures(childrenStr.split(","));
				}
			}
		} catch (Exception e) {
			// ignore - Additional meta-data was not provided in feature.jar
			// log.error(e);
		}
		return feature;
	}

	private Collection<IInstallableUnit> filterInstallableUnits(String idPrefix, String idSuffix,
			IQueryResult<IInstallableUnit> queryResult, IProgressMonitor monitor) throws OperationCanceledException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		Collection<IInstallableUnit> wso2IUs = new ArrayList<IInstallableUnit>();
		Iterator<IInstallableUnit> iterator = queryResult.iterator();
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_24, queryResult.toSet().size());

		while (iterator.hasNext()) {
			if (progress.isCanceled()) {
				throw new OperationCanceledException();
			}
			IInstallableUnit iu = iterator.next();
			String versionedID = iu.getId();
			progress.subTask(Messages.UpdateManager_25 + versionedID);
			if (versionedID != null && versionedID.startsWith(idPrefix) && versionedID.endsWith(idSuffix)) {
				wso2IUs.add(iu);
			}
			progress.worked(1);
		}
		return wso2IUs;
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

	public Collection<IInstallableUnit> getInstalledWSO2Features(IProgressMonitor monitor)
			throws OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(monitor, Messages.UpdateManager_23, 2);

		OperationFactory operationFactory = new OperationFactory();
		IQueryResult<IInstallableUnit> queryResult = operationFactory.listInstalledElements(false, progress.newChild(1));
		return filterInstallableUnits(WSO2_FEATURE_PREFIX, FEATURE_GROUP_IU_ID_SFX, queryResult, progress.newChild(1));
	}

	private void setPossibleUpdates(Update[] possibleUpdates, Map<String, EnhancedFeature> allFeaturesInUpdateRepo) {
		availableUpdates = new HashMap<String, Update>();
		featuresWithPossibleUpdates = new HashMap<String, EnhancedFeature>();
		for (Update update : possibleUpdates) {
			String id = update.replacement.getId();
			String oldVersion = update.toUpdate.getVersion().toString();
			String newVersion = update.replacement.getVersion().toString();
			EnhancedFeature updatebleFeature = allFeaturesInUpdateRepo.get(id);
			updatebleFeature.setCurrentVersion(oldVersion);
			updatebleFeature.setVersion(newVersion);
			updatebleFeature.setUpdateFeature(true);
			if (isNewVersionCompatible(oldVersion, update.replacement.getVersion())) {
				availableUpdates.put(id, update);
				featuresWithPossibleUpdates.put(id, updatebleFeature);
			}
		}
	}

	private boolean isNewVersionCompatible(String currVersion, Version availableVerion) {
		Version upperLimit = generateUpperLimitforUpdates(currVersion);
		if (availableVerion.compareTo(upperLimit) == LESS_THAN) {
			return true;
		}
		return false;
	}

	private URI getDevStudioUpdateSite() {
		URI updateSite = null;
		try {
			IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
			String url = preferenceStore.getString(PreferenceConstants.UPDATE_SITE_URL);
			if (url == null || url.trim().isEmpty()) {
				url = PreferenceInitializer.DEFAULT_UPDATE_SITE;
			}
			updateSite = new URI(url);
		} catch (URISyntaxException e) {
			log.error(e);
		}
		return updateSite;
	}

	private URI getDevStudioReleaseSite() {
		URI releaseSite = null;
		try {
			IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
			String url = preferenceStore.getString(PreferenceConstants.RELESE_SITE_URL);
			if (url == null || url.trim().isEmpty()) {
			    url = PreferenceInitializer.DEFAULT_RELEASE_SITE;
			}
			releaseSite = new URI(url);
		} catch (URISyntaxException e) {
			log.error(e);
		}
		return releaseSite;
	}

	private Version generateUpperLimitforUpdates(String installedVersion) {
		String[] majorMinorUpperLmit = installedVersion.split("\\.");
		int currentMinorVerions = Integer.parseInt(majorMinorUpperLmit[1]);
		int nextMinorVersion = currentMinorVerions + 1;
		Version upperLimit = Version.createOSGi(Integer.parseInt(majorMinorUpperLmit[0]),
				Integer.parseInt(String.valueOf(nextMinorVersion)), Integer.parseInt(majorMinorUpperLmit[2]),
				majorMinorUpperLmit[3]);
		return upperLimit;
	}

}
