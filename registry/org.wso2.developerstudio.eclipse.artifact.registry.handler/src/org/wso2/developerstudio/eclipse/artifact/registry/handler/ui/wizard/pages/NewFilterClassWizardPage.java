package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.PropertyData;

public class NewFilterClassWizardPage extends WizardPage{
	private Text packageNametext;
	private Text classNametext;
	private String packageName;
	private String className;
	private Table filterCriteriaTable;
	private TableViewer viewer;
	private HashMap<String, PropertyData> filterMap;
	private final static String[] TITLES = { "Property Name", "Value", "Type" };
	private String[] filterDataTypeNames = { DataType.STRING.name(), DataType.XML.name() };
	private FilterCreationOptionsWizardPage filterCreationOptionPage;
	
	public NewFilterClassWizardPage(String pageName, FilterCreationOptionsWizardPage filterCreation) {
		super(pageName);
		setDescription("Create a New Filter Class");
		setTitle(pageName);
		filterMap = new HashMap<String, PropertyData>();
		this.filterCreationOptionPage = filterCreation;
	}
	
	public Map<String, PropertyData> getFilterMap() {
		return filterMap;
	}

	public void setFilterMap(HashMap<String, PropertyData> filterMap) {
		this.filterMap = filterMap;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		container.setLayout(layout);
		
		Label lblPackageName = new Label(container, SWT.NONE);
		GridData gd_lblPackageName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPackageName.widthHint = 114;
		lblPackageName.setLayoutData(gd_lblPackageName);
		lblPackageName.setBounds(10, 53, 100, 13);
		lblPackageName.setText("Package Name");
		
		packageNametext = new Text(container, SWT.BORDER);
		GridData gd_packageNametext = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_packageNametext.widthHint = 422;
		packageNametext.setLayoutData(gd_packageNametext);
		packageNametext.setBounds(116, 43, 435, 23);
		
		Label lblHandlerClass = new Label(container, SWT.NONE);
		lblHandlerClass.setText("Filter Class");
		lblHandlerClass.setBounds(10, 97, 100, 13);
		
		classNametext = new Text(container, SWT.BORDER);
		GridData gd_classNametext = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_classNametext.widthHint = 422;
		classNametext.setLayoutData(gd_classNametext);
		classNametext.setBounds(116, 87, 435, 23);
		
		packageNametext.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setPackageName(packageNametext.getText());
				validate();
			}
		});
		
		classNametext.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setClassName(classNametext.getText());
				validate();
			}
		});
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 143, 165, 13);
		lblNewLabel.setText("Filter Criteria");
		
		CellEditor[] editors = new CellEditor[3];

		TableLayout tableLayout = new TableLayout();
		tableLayout.addColumnData(new ColumnWeightData(10, 150, true));
		tableLayout.addColumnData(new ColumnWeightData(15, 450, true));
		tableLayout.addColumnData(new ColumnWeightData(20, 130, true));
		new Label(container, SWT.NONE);

		filterCriteriaTable = new Table(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION | SWT.NO_SCROLL);
		filterCriteriaTable.setHeaderVisible(true);
		filterCriteriaTable.setLinesVisible(true);
		GridData data = new GridData(SWT.CENTER, SWT.FILL, true, false);
		data.horizontalSpan = 3;
		data.widthHint = 700;
		data.heightHint = 300;
		filterCriteriaTable.setLayoutData(data);
		filterCriteriaTable.setLayout(tableLayout);
		TableColumn column = new TableColumn(filterCriteriaTable, SWT.NONE);
		column.setText(TITLES[0]);
		column.setAlignment(SWT.LEFT);
		column = new TableColumn(filterCriteriaTable, SWT.NONE);
		column.setText(TITLES[1]);
		column.setAlignment(SWT.LEFT);
		column = new TableColumn(filterCriteriaTable, SWT.NONE);
		column.setText(TITLES[2]);
		column.setAlignment(SWT.LEFT);

		viewer = new TableViewer(filterCriteriaTable);
		viewer.setColumnProperties(TITLES);
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());
		editors[0] = new TextCellEditor(filterCriteriaTable);
		editors[1] = new TextCellEditor(filterCriteriaTable);
		editors[2] = new ComboBoxCellEditor(filterCriteriaTable, filterDataTypeNames, SWT.READ_ONLY);
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new TableCellModifier());
		
		loadData();
		if(filterCreationOptionPage.getFilterClassCreationMethod().equals(Constants.NEW_FILTER_CLASS)){
			validate();
		}
	
		setControl(container);
		setPageComplete(false);
	}
	
	public static class FilterData {
		String propertyName;
		String propertyValue;
		String type;
		String currentName;
		String currentValue;
		String cType;

		public static FilterData getFilterData(String cPropertyName, String cPropertyValue, String currentType) {
			FilterData filterData = new FilterData();
			filterData.propertyName = cPropertyName;
			filterData.propertyValue = cPropertyValue;
			filterData.type = currentType;
			return filterData;
		}

		public boolean isChanged() {
			return currentName == null || currentValue == null || !currentName.equals(propertyName)
					|| !currentValue.equals(propertyValue) || !cType.equals(type);
		}

		public boolean isBlank() {
			return propertyName.equals("") && propertyValue.equals("") && type.equals("");
		}
	}
	
	private boolean validateXML(String xmlString) {
		try {
			OMElement root = OMAbstractFactory.getOMFactory().createOMElement(new QName("root"));
			OMElement element = AXIOMUtil.stringToOM(xmlString);
			root.addChild(element);
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Registry Handler Artifact",
					"Property value should be well formatted XML string for Type XML");
			return false;
		}
		return true;
	}
	

	public void addFilter() {
		FilterData filterData = FilterData.getFilterData("", "", "");
		viewer.add(filterData);
		TableItem item = filterCriteriaTable.getItem(filterCriteriaTable.getItemCount() - 1);
		item.setData(filterData);
		filterCriteriaTable.setTopIndex(filterCriteriaTable.getItemCount());
		viewer.editElement(filterData, 0);
	}
	
	public void loadData() {
		filterCriteriaTable.removeAll();
		for (String property : filterMap.keySet()) {
			TableItem item = new TableItem(filterCriteriaTable, SWT.NONE);
			PropertyData propDate = filterMap.get(property);
			FilterData filterData = FilterData.getFilterData(property, propDate.data, propDate.type.name());
			item.setText(new String[] { filterData.propertyName, filterData.propertyValue });
			item.setData(filterData);
		}
		addFilter();

	}
	
	public class TableContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object parent) {
			filterMap = new HashMap<String, PropertyData>();
			loadData();

			List results = new ArrayList();
			if (parent instanceof FilterData) {
				results.add((FilterData)parent);
			}
			return results.toArray();
		}

		public void dispose() {

		}

		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

		}

	}

	public class TableLabelProvider extends LabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object arg0, int arg1) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			FilterData row = (FilterData) element;
			switch (columnIndex) {
			case 0:
				return row.propertyName;
			case 1:
				return row.propertyValue;
			case 2:
				return row.type;
			}
			return null;
		}

	}

	class TableCellModifier implements ICellModifier {

		public boolean canModify(Object arg0, String arg1) {
			return true;
		}

		public Object getValue(Object element, String property) {
			Object result = null;
			FilterData row = (FilterData) element;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < TITLES.length; i++) {
				list.add(TITLES[i]);
			}
			int columnIndex = list.indexOf(property);
			switch (columnIndex) {
			case 0:
				result = row.propertyName;
				break;
			case 1:
				result = row.propertyValue;
				break;
			case 2:
				result = row.type;
				String[] choices = filterDataTypeNames;
				int i = choices.length - 1;
				while (!result.equals(choices[i]) && i > 0) {
					--i;
				}
				result = new Integer(i);
				break;
			}

			return result;
		}

		public void modify(Object element, String property, Object value) {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < TITLES.length; i++) {
				list.add(TITLES[i]);
			}
			int columnIndex = list.indexOf(property);

			TableItem tableItem = (TableItem) element;
			FilterData row = (FilterData) tableItem.getData();

			switch (columnIndex) {
			case 0:
				String key = (String) value;
				if (key.length() > 0) {
					row.propertyName = key;
				}
				break;

			case 1:
				String v = (String) value;
				if (v.length() > 0) {
					row.propertyValue = v;
				}
				break;
			case 2:
				String ctype = filterDataTypeNames[((Integer) value).intValue()].trim();
				if (!row.type.equals(ctype)) {
					row.type = ctype;
				}
			}
			if (row.isBlank()) {
				if (tableItem != filterCriteriaTable.getItem(filterCriteriaTable.getItemCount() - 1)) {
				}
			} else {
				TableItem item = filterCriteriaTable.getItem(filterCriteriaTable.getItemCount() - 1);
				FilterData lastFilterData = (FilterData) item.getData();
				if (!lastFilterData.isBlank()) {
					addFilter();
				}
			}
			viewer.update(row, null);
			if (row.propertyName != null && !row.propertyName.equals("") && row.propertyValue != null
					&& !row.propertyValue.equals("")) {
				PropertyData prpData = new PropertyData(row.type.equalsIgnoreCase("xml") ? DataType.XML
						: DataType.STRING, row.propertyValue);
				if (prpData.type.name().equals(DataType.XML.name())) {
					if (validateXML(prpData.data)) {
						filterMap.put(row.propertyName, prpData);
						setFilterMap(filterMap);
					}

				} else {
					filterMap.put(row.propertyName, prpData);
					setFilterMap(filterMap);
				}

			}

		}

	}
	
	
	public void validate(){
		if(packageNametext.getText() == null || packageNametext.getText().equals("")){
			setErrorMessage("Package name cannot be empty");
			setPageComplete(false);
		}
		if(classNametext.getText() == null || classNametext.getText().equals("")){
			setErrorMessage("Package name cannot be empty");
			setPageComplete(false);
		}
		if(!packageNametext.getText().equals("") && !classNametext.getText().equals("")){
			setErrorMessage(null);
			setPageComplete(true);
		}
		getWizard().canFinish();
		getWizard().getContainer().updateButtons();
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

}
