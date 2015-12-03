package org.wso2.developerstudio.eclipse.updater.ui;

import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.updater.UpdaterPlugin;
import org.wso2.developerstudio.eclipse.updater.core.UpdateManager;
import org.wso2.developerstudio.eclipse.updater.model.EnhancedFeature;

public class UpdaterDialog extends Dialog {
	
	private UpdateManager updateManager;
	private ActiveTab activeTab;

	protected static IDeveloperStudioLog log = Logger
			.getLog(UpdaterPlugin.PLUGIN_ID);

	public enum ActiveTab {
		ALL_FEATURES, UPDATE_FEATURES
	}

	public UpdaterDialog(UpdateManager updateManager, ActiveTab activeTab) {
		super(Display.getDefault().getActiveShell());
		this.activeTab = activeTab;
		this.updateManager = updateManager;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite topContainer = createTopContainer(parent);
		Composite leftContainer = createSubColumnContainer(topContainer);
		TabFolder tabFolder = createLeftContainerTabFolder(leftContainer);
		createFeatureItemsInTabFolder(tabFolder);
		if (activeTab == ActiveTab.ALL_FEATURES) {
			tabFolder.setSelection(0);
		} else {
			tabFolder.setSelection(1);
		}
		return topContainer;
	}

	private void createFeatureItemsInTabFolder(TabFolder tabFolder) {
		createFeatureListTab(tabFolder, ActiveTab.ALL_FEATURES);
		createFeatureListTab(tabFolder,
				ActiveTab.UPDATE_FEATURES);
	}

	private void createFeatureListTab(TabFolder tabFolder,
			ActiveTab type) {

		TabItem tabItem = new TabItem(tabFolder, SWT.NULL);
		tabItem.setText(type.toString());
		ScrolledComposite scroll = new ScrolledComposite(tabFolder,
				SWT.V_SCROLL | SWT.H_SCROLL);
		scroll.setLayout(new GridLayout());
		scroll.setLayoutData(new GridData());

		Group group = new Group(scroll, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData());
		listFeatures(group, type);
		scroll.setContent(group);
		scroll.setExpandHorizontal(true);
		scroll.setExpandVertical(true);
		scroll.setMinSize(group.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		tabItem.setControl(scroll);
	}

	private TabFolder createLeftContainerTabFolder(Composite leftContainer) {
		GridData tabGridData = new GridData();
		tabGridData.horizontalAlignment = GridData.FILL;
		tabGridData.verticalAlignment = GridData.FILL;
		tabGridData.horizontalSpan = 3;
		tabGridData.verticalSpan = 7;
		tabGridData.grabExcessVerticalSpace = true;
		tabGridData.heightHint = 750;
		tabGridData.widthHint = 700;

		TabFolder tabFolder = new TabFolder(leftContainer, SWT.CHECK
				| SWT.BORDER | SWT.H_SCROLL);
		tabFolder.setLayoutData(tabGridData);
		tabFolder.setSize(400, 420);
		return tabFolder;
	}

	private Composite createSubColumnContainer(final Composite topContainer) {
		Composite leftContainer = new Composite(topContainer, SWT.NONE);
		leftContainer.setLayout(new GridLayout(1, false));
		GridData leftContainerGridData = new GridData(GridData.FILL_BOTH);
		leftContainer.setLayoutData(leftContainerGridData);
		return leftContainer;
	}

	private Composite createTopContainer(Composite parent) {
		final Composite topContainer = new Composite(parent, SWT.NONE);
		GridData topContainerGridData = new GridData(GridData.FILL_BOTH);
		topContainerGridData.heightHint = 800;
		topContainer.setLayoutData(topContainerGridData);
		GridLayout topContainerGridLayout = new GridLayout();
		topContainerGridLayout.numColumns = 1;
		topContainerGridLayout.makeColumnsEqualWidth = true;
		topContainer.setLayout(topContainerGridLayout);
		return topContainer;
	}

	private void listFeatures(Group group, ActiveTab type) {
		Iterator<Entry<String, EnhancedFeature>> featureList;
		if (type == ActiveTab.ALL_FEATURES) {
			featureList = updateManager.getAvailableFeaturesMap().entrySet().iterator();
		} else {
			featureList = updateManager.getPossibleUpdatesMap().entrySet().iterator();;
		}
		while (featureList.hasNext()) {
			
			EnhancedFeature feature = featureList.next().getValue();

//			FIXME - uncomment this when we need to remove kernel features
//			if(feature.isKernelFeature()){
//				continue;
//			}

			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
			final Group featureGroup = createFeatureRepresentationGroup(group,
					gridData);
			createCheckBoxInFeatureGroup(featureGroup);
			
			Label featureImageLabel = new Label(featureGroup, SWT.NONE);
			try {
				Image image = new Image(Display.getDefault(), feature
						.getIconURL().replace("file:", ""));
				featureImageLabel.setImage(image);
			} catch (Exception ex) {
				log.warn("Image Failed for feature:" + feature.getId(), ex);
			}
			final Group featureInfoGroup = createFeatureInfoRepresentationGroup(featureGroup);
			StyledText featureName = createFeatureNameText(feature,
					featureInfoGroup);
			FontData fontData = featureName.getFont().getFontData()[0];
			Font font = new Font(featureInfoGroup.getDisplay(), new FontData(
					fontData.getName(), fontData.getHeight() + 3, SWT.BOLD));
			featureName.setFont(font);
			createFeatureNewVersionText(feature, featureInfoGroup);
		}
	}

	private void createFeatureNewVersionText(EnhancedFeature feature,
			final Group featureInfoGroup) {
		StyledText featureNewVersion = new StyledText(featureInfoGroup,
				SWT.WRAP);
		String featureVersionString = "Latest Version : "
				+ feature.getVersion();
		featureNewVersion.setText(featureVersionString);
	}

	private StyledText createFeatureNameText(EnhancedFeature feature,
			final Group featureInfoGroup) {
		StyledText featureName = new StyledText(featureInfoGroup, SWT.WRAP);
		final String featureNameString = feature.getLabel();
		featureName.setText(featureNameString);
		return featureName;
	}

	private Group createFeatureInfoRepresentationGroup(final Group featureGroup) {
		GridData gridData;
		final Group featureInfoGroup = new Group(featureGroup, SWT.NONE);
		featureInfoGroup.setBackground(featureGroup.getDisplay()
				.getSystemColor(SWT.COLOR_WHITE));
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan = 2;
		featureInfoGroup.setLayoutData(gridData);
		featureInfoGroup.setLayout(new GridLayout(1, false));
		return featureInfoGroup;
	}

	private void createCheckBoxInFeatureGroup(final Group featureGroup) {
		final Button checkBox = new Button(featureGroup, SWT.CHECK);
		checkBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (checkBox.getSelection()) {
					System.out.println(true);
				} else {
					System.out.println(false);
				}
			}
		});
	}

	private Group createFeatureRepresentationGroup(Group group,
			GridData gridData) {
		final Group featureGroup = new Group(group, SWT.NONE);
		featureGroup.setBackground(featureGroup.getDisplay().getSystemColor(
				SWT.COLOR_WHITE));
		gridData.horizontalSpan = 2;
		featureGroup.setLayout(new GridLayout(4, false));
		featureGroup.setLayoutData(gridData);
		return featureGroup;
	}

}
