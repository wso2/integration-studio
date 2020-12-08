package org.wso2.developerstudio.eclipse.registry.base.ui.dialog;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CreateRegistryDilaog  extends Dialog{

	private static String[] captionList;
	private static String[] pathList;
	private String serverUrl;
	private String path;
	private Combo pathText;
//	private String connectionName;
	private int defaultPathId=0;
	
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

//	public String getConnectionName() {
//		return connectionName;
//	}
//
//	public void setConnectionName(String connectionName) {
//		this.connectionName = connectionName;
//	}

	protected CreateRegistryDilaog(Shell parentShell) {
		super(parentShell);

	}
	
	protected CreateRegistryDilaog(Shell parentShell,int defaultPathId ) {
		super(parentShell);
		List<String> defaultPaths = getDefaultPaths();
		if(defaultPaths.size()>defaultPathId){
			setDefaultPathId(defaultPathId);
		}
		else{
			setDefaultPathId(0);
		}
	}
	
	public void create() {
		super.create();

	}
	
	protected Control createDialogArea(final Composite parent) {
		Composite container = new Composite(parent,SWT.None);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		Group group = new Group(container,SWT.None);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		layout = new GridLayout();
		layout.numColumns = 2;
		group.setLayout(layout);
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);

		gd=new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan=2;
		new Label(group,SWT.SEPARATOR|SWT.HORIZONTAL).setLayoutData(gd);
		
		Label urlLabel = new Label(group, SWT.NONE);
		GridData gd_urlLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_urlLabel.widthHint = 100;
		urlLabel.setLayoutData(gd_urlLabel);
		urlLabel.setText("URL ");

		Text urlText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		urlText.setLayoutData(gd);

		urlText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text url = (Text) event.widget;
				serverUrl = url.getText();
				setServerUrl(serverUrl);
			}
		});

		Label pathLabel = new Label(group, SWT.NONE);
		pathLabel.setText("Path ");
		
		urlText.setText("https://localhost:9443");
		
		pathText = new Combo(group, SWT.NONE);
		pathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				updateSelectedPath();
			}
		});
		pathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		pathText.removeAll();
		List<String> defaultPaths = getDefaultPaths();
		for (String path : defaultPaths) {
			pathText.add(path);
		}
		pathText.select(getDefaultPathId());
		updateSelectedPath();
		return super.createDialogArea(parent);
	}

	private void updateSelectedPath(){
		List<String> defaultPaths = getDefaultPaths();
		String selectedPath = pathText.getText();
		if (defaultPaths.contains(selectedPath)){
			setPath(pathList[defaultPaths.indexOf(selectedPath)]);
		}else{
			setPath(selectedPath);
		}
	}
	
	private static List<String> getDefaultPaths(){
		pathList = new String[]{
				"/",
				"/_system/local",
				"/_system/config",
				"/_system/governance"
		};
		captionList = new String[]{
				"/",
				"Local registry",
				"Configuration registry",
				"Governance registry"
		};
		return Arrays.asList(captionList);
	}

	public void setDefaultPathId(int defaultPathId) {
		this.defaultPathId = defaultPathId;
	}

	public int getDefaultPathId() {
		return defaultPathId;
	}
}
