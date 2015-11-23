package org.wso2.developerstudio.eclipse.ds.presentation.data;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.ds.DataService;
import org.wso2.developerstudio.eclipse.ds.DataSourceConfiguration;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;
import org.wso2.developerstudio.eclipse.ds.presentation.util.DsUtil;

public class DataSourcePage extends FormPage {

	private static final String NO_EXISTING_DATA_SOURCE_MSG =
	                                                          "No existing data source configurations";

	private DsEditor dsEditor;
	private EditingDomain editingDomain;
	private DataService dataService;
	private Form form;
	protected String pageTitle;
	protected FormToolkit toolkit;

	private TableViewer dataSourceViewer;
	private Table datasourceTable;

	private DataSourceConfiguration selectedConfig;

	public DataSourcePage(DsEditor editor, DataService dataService) {
		super(editor, "DSSP", "Data Sources");
		this.pageTitle = super.getTitle();
		this.dsEditor = editor;
		this.dataService = dataService;
		this.editingDomain = dsEditor.getEditingDomain();
	}

	protected void createFormContent(IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		form = managedForm.getForm().getForm();
		form.setText("Data Sources");
		toolkit.decorateFormHeading(form);

		GridLayout layout = new GridLayout(); // layout for the form body
		layout.numColumns = 1;
		layout.marginWidth = 10;
		form.getBody().setLayout(layout);

		checkDataSourceAvailability();

		createDataSourceTableSection(form.getBody());
	}

	private void createDataSourceTableSection(Composite parent) {

		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText("Existing Data Sources");
		section.marginWidth = 10;
		section.marginHeight = 5;
		GridData sectiondata = new GridData(GridData.FILL_BOTH);
		section.setLayoutData(sectiondata);

		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);

		toolkit.paintBordersFor(client);
		section.setClient(client);

		dataSourceViewer =
		                   new TableViewer(client, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL |
		                                           SWT.FULL_SELECTION | SWT.BORDER);
		createLogicalPplColumns(client, dataSourceViewer);

		datasourceTable = dataSourceViewer.getTable();

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.heightHint = 100;

		datasourceTable.setLayoutData(gd);
		datasourceTable.setHeaderVisible(true);
		datasourceTable.setLinesVisible(true);

		dataSourceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// logiclPplTableitemSelecter(event.getSelection());

			}
		});

		dataSourceViewer.setContentProvider(new DatSourceTableContentProvider());
		if (selectedConfig != null)
			dataSourceViewer.setInput(getDataSourceModel());

		datasourceTable.setSelection(0);

	}

	private void createLogicalPplColumns(Composite parent, TableViewer viewer) {
		String[] titles = { "Existing Data Sources", "Actions" };
		int[] bounds = { 100 };

		// first column for the Existing data Sources
		TableViewerColumn col = DsUtil.createTableViewerColumn(viewer, titles[0], bounds[0]);

		col.setLabelProvider(new ColumnLabelProvider() {

			public String getText(Object element) {

				DataSourceConfiguration configuration = (DataSourceConfiguration) element;
				return configuration.getId();

			}

		});

	}

	private class DatSourceTableContentProvider implements IStructuredContentProvider {

		public void dispose() {
			// TODO Auto-generated method stub

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		public Object[] getElements(Object inputElement) {
			DataSourceConfiguration[] configs =
			                                    Arrays.copyOf((Object[]) inputElement,
			                                                  Array.getLength(inputElement),
			                                                  DataSourceConfiguration[].class);
			return configs;
		}

	}

	private void checkDataSourceAvailability() {

		if (dataService != null) {

			if (dataService.getConfig() != null && !dataService.getConfig().isEmpty()) {

				if (dataService.getConfig().get(0) != null) {

					selectedConfig = dataService.getConfig().get(0);

				} else {
					form.setMessage(NO_EXISTING_DATA_SOURCE_MSG, IMessageProvider.ERROR);
				}
			} else {
				form.setMessage(NO_EXISTING_DATA_SOURCE_MSG, IMessageProvider.ERROR);
			}
		} else {
			form.setMessage(NO_EXISTING_DATA_SOURCE_MSG, IMessageProvider.ERROR);
		}

	}

	public Object getDataSourceModel() {

		return dataService.getConfig().toArray();
	}

	public void updateDataSourceViewer() {

		dataSourceViewer.setInput(getDataSourceModel());

		if (dataService.getConfig().size() != 0)
			clearFormHeaderMessage();

	}

	public void clearFormHeaderMessage() {

		if (form.getMessage() != null && form.getMessage().equals(NO_EXISTING_DATA_SOURCE_MSG))
			form.setMessage("");
	}

	public String getTitle() {
		return this.pageTitle;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

}
