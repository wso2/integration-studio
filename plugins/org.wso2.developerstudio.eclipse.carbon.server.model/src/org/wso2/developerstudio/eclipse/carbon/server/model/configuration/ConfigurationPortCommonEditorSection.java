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

package org.wso2.developerstudio.eclipse.carbon.server.model.configuration;


import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.ui.editor.ServerEditorSection;
import org.wso2.developerstudio.eclipse.carbon.server.model.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;

public abstract class ConfigurationPortCommonEditorSection extends ServerEditorSection {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	protected Table ports;
	protected TableViewer viewer;

	/**
	 * ConfigurationPortEditorSection constructor comment.
	 */
	public ConfigurationPortCommonEditorSection() {

		super();
	}

	/**
	 * 
	 */
	protected void addChangeListener() {
	}

	/**
	 * 
	 * @param name
	 *            java.lang.String
	 * @param port
	 *            int
	 */
	protected abstract void changePortNumber(String name, int port);

	/**
	 * Creates the SWT controls for this workbench part.
	 *
	 * @param parent
	 *            the parent control
	 */
	public void createSection(Composite parent) {
		super.createSection(parent);
		FormToolkit toolkit = getFormToolkit(parent.getDisplay());

		Section section =
		                  toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED |
		                                                ExpandableComposite.TITLE_BAR | Section.DESCRIPTION |
		                                                ExpandableComposite.FOCUS_TITLE);
		section.setText("Ports");
		section.setDescription("Modify the server ports.");
		section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));

		// ports
		Composite composite = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 8;
		layout.marginWidth = 8;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.FILL_HORIZONTAL));
		toolkit.paintBordersFor(composite);
		section.setClient(composite);

		ports = toolkit.createTable(composite, SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
		ports.setHeaderVisible(true);
		ports.setLinesVisible(true);

		TableLayout tableLayout = new TableLayout();

		TableColumn col = new TableColumn(ports, SWT.NONE);
		col.setText("Port Name");
		ColumnWeightData colData = new ColumnWeightData(15, 150, true);
		tableLayout.addColumnData(colData);

		col = new TableColumn(ports, SWT.NONE);
		col.setText("Value");
		colData = new ColumnWeightData(8, 80, true);
		tableLayout.addColumnData(colData);

		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL);
		data.widthHint = 230;
		data.heightHint = 100;
		ports.setLayoutData(data);
		ports.setLayout(tableLayout);

		viewer = new TableViewer(ports);
		viewer.setColumnProperties(new String[] { "name", "port" });

		initialize();
	}

	protected void setupPortEditors() {
		viewer.setCellEditors(new CellEditor[] { null, new TextCellEditor(ports) });

		ICellModifier cellModifier = new ICellModifier() {
			public Object getValue(Object element, String property) {
				ServerPort sp = (ServerPort) element;
				if (sp.getPort() < 0)
					return "-";
				return sp.getPort() + "";
			}

			public boolean canModify(Object element, String property) {
				if ("port".equals(property))
					return true;

				return false;
			}

			public void modify(Object element, String property, Object value) {
				try {
					Item item = (Item) element;
					ServerPort sp = (ServerPort) item.getData();
					int port = Integer.parseInt((String) value);
					changePortNumber(sp.getName(), port);
				} catch (Exception ex) {
					log.error(ex);
				}
			}
		};
		viewer.setCellModifier(cellModifier);

		// preselect second column (Windows-only)
		String os = System.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("win") >= 0) {
			ports.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					try {
						int n = ports.getSelectionIndex();
						viewer.editElement(ports.getItem(n).getData(), 1);
					} catch (Exception e) {
						log.error(e);
					}
				}
			});
		}
	}

	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * Initializes the editor part with a site and input.
	 */
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);

		GenericServer gserver = (GenericServer) server.getOriginal().getAdapter(GenericServer.class);
		try {
			gserver.getServerInstanceProperties();
			int a = 10;
		} catch (Exception e) {
			log.error(e);
		}
		addChangeListener();
		initialize();
	}

	protected abstract void initialize();
}
