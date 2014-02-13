package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.PropertyData;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class ImportFilterClassWizardPage extends WizardPage{
	
	private Table filterCriteriaTable;
	private TableViewer viewer;
	private HashMap<String, PropertyData> filterMap;
	private final static String[] titles = { "Property Name", "Value", "Type" };
	private String[] filterDataTypeNames = { DataType.STRING.name(), DataType.XML.name() };
	private ArrayList<String> allFilterClassesList;
	private Combo filterClassesCombo;
	private String className;
	private Map<String, List<String>> filterClassesList = new HashMap<String, List<String>>();
	private Map<String, String> projectsMap = new HashMap<String, String>();
	

	public ImportFilterClassWizardPage(String pageName) {
		super(pageName);
		setDescription("Select Filter class from already defined Filters");
		setTitle(pageName);
		filterMap = new HashMap<String, PropertyData>();
	}
	
	public Map<String, PropertyData> getFilterMap() {
		return filterMap;
	}

	public void setFilterMap(HashMap<String, PropertyData> filterMap) {
		this.filterMap = filterMap;
	}

	public void createControl(Composite parent) {
		allFilterClassesList = new ArrayList<String>();
		allFilterClassesList.add(Constants.CLASS_FQN_MEDIA_TYPE_MATCHER);
		allFilterClassesList.add(Constants.CLASS_FQN_URL_MATCHER);
		
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		container.setLayout(layout);
		
		Label lblFilterClass = new Label(container, SWT.NONE);
		lblFilterClass.setText("Filter Class");
		lblFilterClass.setBounds(10, 54, 100, 13);
		
		filterClassesCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		filterClassesCombo.setBounds(116, 40, 435, 27);
		
		getAllFilterClasses();
		fillComboBoxInfo(allFilterClassesList);
		
		filterClassesCombo.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				setClassName(filterClassesCombo.getText());
				if (filterClassesCombo.getText().equals(
						Constants.CLASS_FQN_MEDIA_TYPE_MATCHER)) {
					getMediaTypeMatcherFilterMap();
				} else if (filterClassesCombo.getText().equals(
						Constants.CLASS_FQN_URL_MATCHER)) {
					getURLMatcherFilterMap();
				} else {
					getFilterMapForClass(filterClassesCombo.getText());
				}
				setClassName(filterClassesCombo.getText());
				loadData();
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 97, 165, 13);
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
		column.setText(titles[0]);
		column.setAlignment(SWT.LEFT);
		column = new TableColumn(filterCriteriaTable, SWT.NONE);
		column.setText(titles[1]);
		column.setAlignment(SWT.LEFT);
		column = new TableColumn(filterCriteriaTable, SWT.NONE);
		column.setText(titles[2]);
		column.setAlignment(SWT.LEFT);

		viewer = new TableViewer(filterCriteriaTable);
		viewer.setColumnProperties(titles);
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());
		editors[0] = new TextCellEditor(filterCriteriaTable);
		editors[1] = new TextCellEditor(filterCriteriaTable);
		editors[2] = new ComboBoxCellEditor(filterCriteriaTable, filterDataTypeNames, SWT.READ_ONLY);
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new TableCellModifier());
		
		loadData();
		setControl(container);
	}
	
	public void fillComboBoxInfo(List<String> filterClasses) {
		filterClassesCombo.removeAll();
		for (int i = 0; i < filterClasses.size(); i++) {
			filterClassesCombo.add(filterClasses.get(i));
		}
		// serverClassesCombo.add("--Existing Class From Server--");
		if (filterClassesCombo.getItemCount() > 0 && filterClassesCombo.getSelectionIndex() == -1) {
			filterClassesCombo.select(0);
			setClassName(filterClassesCombo.getText());
		}

		if (filterClassesCombo.getText().equals(Constants.CLASS_FQN_MEDIA_TYPE_MATCHER)) {
			getMediaTypeMatcherFilterMap();
		} else if (filterClassesCombo.getText()
				.equals(Constants.CLASS_FQN_URL_MATCHER)) {
			getURLMatcherFilterMap();
		} else {
			getFilterMapForClass(filterClassesCombo.getText());
		}

		setClassName(filterClassesCombo.getText());
		// loadData();
	}
	
	public void getURLMatcherFilterMap() {
		filterMap = new HashMap<String, PropertyData>();
		String[] properties = { "getPattern", "putPattern", "importPattern", "deletePattern", "putChildPattern",
				"importChildPattern", "invokeAspectPattern", "movePattern", "copyPattern", "renamePattern",
				"createLinkPattern", "removeLinkPattern", "resourceExistsPattern", "addAssociationPattern",
				"removeAssociationPattern", "getAllAssociationsPattern", "getAssociationsPattern", "applyTagPattern",
				"getTagsPattern", "removeTagPattern", "addCommentPattern", "editCommentPattern",
				"removeCommentPattern", "getCommentsPattern", "rateResourcePattern", "getAverageRatingPattern",
				"getRatingPattern", "createVersionPattern", "getVersionsPattern", "restoreVersionPattern",
				"dumpPattern", "restorePattern" };

		for (String string : properties) {
			filterMap.put(string, new PropertyData(DataType.STRING, ""));
		}
	}
	
	public List<String> getAllFilterClasses(){
		determineFilterClassProjects();
		
		projectsMap.clear();
		for (String key: filterClassesList.keySet()) {
			List<String> list = filterClassesList.get(key);
			for (String fqn : list) {
				if(!allFilterClassesList.contains(list)){
					allFilterClassesList.add(fqn);
					// add fqn and key to projectsMap
					projectsMap.put(fqn, key);
				}
			}
		}
		return allFilterClassesList;
	}
	
	public void determineFilterClassProjects() {

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		ArrayList<IProject> filterProjectList = new ArrayList<IProject>();
		for (IProject prj : projects) {
			try {
				if (!prj.isOpen() || !prj.hasNature(Constants.JAVA_NATURE_ID)) {
					continue;
				}
			} catch (CoreException e1) {
				e1.printStackTrace();
				continue;
			}
			IJavaProject jp = JavaCore.create(prj);
			try {
				IPackageFragment[] packageFragments = jp.getPackageFragments();
				for (IPackageFragment fragment : packageFragments) {
					IJavaElement[] children = fragment.getChildren();
					for (IJavaElement element : children) {
						ICompilationUnit[] compilationUnits = fragment.getCompilationUnits();
						for (ICompilationUnit unit : compilationUnits) {
							String a = unit.getElementName();
							IType[] types = unit.getTypes();
							for (IType type : types) {
								if (type.getSuperclassName() != null) {
									String[][] resolveType = type.resolveType(type.getSuperclassName());
									if (resolveType != null) {
										String fullyQualifiedSuperClassName = (resolveType[0][0]).toString() + "."
												+ (resolveType[0][1]).toString();
										if (isClassExtendedFromFilterClass(prj, fullyQualifiedSuperClassName)) {
											String fullyQualifiedName = type.getFullyQualifiedName();
											addFilterClassProject(prj.getName(), fullyQualifiedName);
										}
									}
								}
							}
						}
						// }
					}
				}
			} catch (JavaModelException e) {
				
			}
		}
	}
	
	private void addFilterClassProject(String projectName, String className) {
		if (!filterClassesList.containsKey(projectName)) {
			filterClassesList.put(projectName, new ArrayList<String>());
		}
		List<String> list = filterClassesList.get(projectName);
		if (!list.contains(className)) {
			list.add(className);
		}
	}

	private boolean isClassExtendedFromFilterClass(IProject project, String fullyQualifiedClassName)
			throws JavaModelException {
		return JavaUtils.isClassExtendedFrom(project, fullyQualifiedClassName, Constants.FILTER_SUPER_CLASSNAME);
	}
	
	public void getFilterMapForClass(String classname) {
		filterMap = new HashMap<String, PropertyData>();
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			IJavaProject javaProject = JavaCore.create(project);
			try {
				IType classType = javaProject.findType(classname);
				IMethod[] methods = classType.getMethods();
				for (IMethod iMethod : methods) {
					if (iMethod.getElementName().startsWith("set")) {
						filterMap.put(getFilterPropertyName(iMethod.getElementName()),
								new PropertyData(DataType.STRING, ""));
					}
				}
			} catch (JavaModelException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	public String getFilterPropertyName(String methodName) {
		String propertyName = methodName.substring(3);
		Character.toUpperCase(propertyName.toCharArray()[0]);
		return propertyName;
	}

	
	public void getMediaTypeMatcherFilterMap() {
		filterMap = new HashMap<String, PropertyData>();
		String[] properties = { "mediaType" };

		for (String string : properties) {
			filterMap.put(string, new PropertyData(DataType.STRING, ""));
		}
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
			OMElement element = AXIOMUtil.stringToOM(xmlString);
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
	
	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public class TableContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object parent) {
			filterMap = new HashMap<String, PropertyData>();
			loadData();

		    List results = new ArrayList();
			if (parent instanceof FilterData) {
				results.add((FilterData) parent);
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
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
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
			for (int i = 0; i < titles.length; i++) {
				list.add(titles[i]);
			}
			int columnIndex = list.indexOf(property);

			TableItem tableItem = (TableItem) element;
			FilterData row = (FilterData) tableItem.getData();

			switch (columnIndex) {
			case 0:
				String key = (String) value;
				if (key.length() > 0) {
					if(!validateProperty(tableItem,key)){
						String oldKey = key;
						key = getNewPropertyName(key);
						MessageDialog.openInformation(getShell(), 
						                              "Registry Handler Artifact",
						                              "The property name must be unique"
						                              + " \'" + oldKey + "\' " +
						                              "will be renamed to"
						                              + " \'" + key + "\'");
						tableItem.setText(0,key);
					}
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
	
	private boolean validateProperty(TableItem tableItem,String key){
		TableItem[] items = viewer.getTable().getItems();
		for (TableItem item : items) {
	        if(item.equals(tableItem))
	        	continue;
	        String property = item.getText(0);
	        if(property.equals(key))
	        	return false;
        }
		return true;
	}
	
	private String getNewPropertyName(String key) {
		TableItem[] items = viewer.getTable().getItems();
		return getKey(items,key,0);
	}
	
	private String getKey(TableItem[] items , String key , int i){
		String newKey = key.replaceAll("\\d+$", "") + ++i;
		for (TableItem item : items) {
			String property = item.getText(0);
			if (property.equals(newKey)){
					newKey =getKey(items,newKey,i);
				  break;
			    } 
			}
	 return newKey;		
	}

	public String getProject(String key) {
		if (projectsMap.get(key) != null) {
			return projectsMap.get(key);
		} else {
			return "";
		}
	}
	
}
