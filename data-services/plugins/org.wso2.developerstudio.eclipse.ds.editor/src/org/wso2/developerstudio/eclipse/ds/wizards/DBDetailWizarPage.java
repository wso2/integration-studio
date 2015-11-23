package org.wso2.developerstudio.eclipse.ds.wizards;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class DBDetailWizarPage extends WizardPage implements Listener {

	public static final String PAGE_NAME = "DBDetailWizardPage";

	private static final String[] DB_TABLE_TYPES = { "TABLE" };
	private static final String TABLE_NAME = "TABLE_NAME";

	private Composite client;
	private ArrayList<String> selectedTables;

	private TableViewer tableViewer;
	private Table tableT;

	public DBDetailWizarPage() {

		super(PAGE_NAME, "Database Information", null);

	}

	public void createControl(Composite parent) {

		client = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, true);
		client.setLayout(layout);

		Label tbl = new Label(client, SWT.WRAP);
		tbl.setText("Select Table(s)");

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		tbl.setLayoutData(gd);

		tableViewer =
		              new TableViewer(client, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL |
		                                      SWT.FULL_SELECTION | SWT.BORDER | SWT.CHECK);

		createTableViewerColumns(client, tableViewer);

		tableT = tableViewer.getTable();
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;

		tableT.setLayoutData(gd);

		tableT.setHeaderVisible(true);
		tableT.setLinesVisible(true);
		tableT.addListener(SWT.Selection, this);
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableT.setSelection(0);

		setControl(client);

	}

	protected void init(Connection connection) throws SQLException {

		ArrayList<String> tableNames = populateTableNames(connection);

		selectedTables = new ArrayList<String>();

		if (tableNames != null && tableNames.size() != 0) {

			tableViewer.setInput(tableNames);

		}

	}

	private void createTableViewerColumns(Composite parent, TableViewer viewer) {
		String[] titles = { "Table Names" };
		int[] bounds = { 200, 150, 150 };

		TableViewerColumn col1 = createTableViewerColumn(viewer, titles[0], bounds[0]);
		col1.setLabelProvider(new ColumnLabelProvider() {

			public String getText(Object element) {

				String tName = (String) element;
				return tName;

			}

		});

	}

	private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;

	}

	private ArrayList<String> populateTableNames(Connection connection) throws SQLException {

		ArrayList<String> tableNames = new ArrayList<String>();

		DatabaseMetaData dbMetaData = connection.getMetaData();
		ResultSet rs = dbMetaData.getTables(null, null, null, DB_TABLE_TYPES);

		while (rs.next()) {

			String tableName = rs.getString(TABLE_NAME);

			if (tableName != null) {
				tableNames.add(tableName);
			}
		}

		return tableNames;

	}

	public boolean canFlipToNextPage() {
		if (selectedTables.size() != 0)
			return true;
		return true;
	}

	public IWizardPage getNextPage() {

		if (this.selectedTables != null && selectedTables.size() != 0) {
			// ((DataServiceCreationWizard)
			// getWizard()).serviceGenModePage.setConnection(this.);
			((DataServiceCreationWizard) getWizard()).serviceGenModePage.setSelectedTableNames(this.selectedTables);

			return ((DataServiceCreationWizard) getWizard()).serviceGenModePage;
		}

		return null;

	}

	public void handleEvent(Event event) {

		if (event.detail == SWT.CHECK) {

			TableItem item = (TableItem) event.item;

			feedSelectedTableList(item.getChecked(), item);

		}

		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();

	}

	private void feedSelectedTableList(boolean isSelected, TableItem checkbtn) {

		if (isSelected) {

			selectedTables.add(checkbtn.getText());
		} else {

			selectedTables.remove(checkbtn.getText());
		}

	}

	public boolean isPageComplete() {

		if (canFlipToNextPage())
			return true;

		return false;
	}

}
