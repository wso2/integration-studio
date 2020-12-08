package org.wso2.developerstudio.eclipse.carbonserver.remote.configuration;

import java.net.MalformedURLException;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;
import org.wso2.developerstudio.eclipse.carbonserver.remote.internal.RemoteCarbonServer;

public class ConfigurationServerInfoSection extends ServerEditorSection {

	private Text urlText;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ConfigurationServerInfoSection() {
		super();
	}

	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
	}

	public void createSection(final Composite parent) {
		super.createSection(parent);
		GridData gd;
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());
		final RemoteCarbonServer rcs = (RemoteCarbonServer) server.loadAdapter(RemoteCarbonServer.class, null);

		Section section =
		                  toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED |
		                                                ExpandableComposite.TITLE_BAR | Section.DESCRIPTION |
		                                                ExpandableComposite.FOCUS_TITLE);
		section.setText("Remote Server Info");
		section.setDescription("Remote Server Information");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

		Composite composite = toolkit.createComposite(section);
		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = 8;
		layout.marginWidth = 8;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		toolkit.createLabel(composite, "Server URL");
		urlText = toolkit.createText(composite, rcs.getServerURL().toString());
		urlText.setEditable(false);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 200;
		urlText.setLayoutData(gd);

		urlText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent arg0) {
				setUrl(urlText.getText());
			}
		});

	}
}
