package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.DataType;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.HandlerInfo.PropertyData;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.apache.axiom.om.util.AXIOMUtil;

public class HandlerMethodsInfoPage extends WizardPage{
	private Table handlerPropertiesTable;
	private Table handlerMethodsTable;
	private TableViewer viewer;
	private final static String[] TITLES = { "Property Name", "Value", "Type" };
	private String[] handlerTypes = {DataType.STRING.name(), DataType.XML.name()};
	private HashMap<String, PropertyData> handlerPropertyMap;
	private String[] methodTypes;
	private Button selectAllButton;
	private Button deSelectAllButton;
	private Button btnRemove;
	private ArrayList<String> selectedMethods;

	public HandlerMethodsInfoPage(String pageName) {
		super(pageName);
		setDescription("Handler Class Information");
		setTitle(pageName);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		container.setLayout(layout);	
		
		GridData gd = new GridData();
		
		selectedMethods = new ArrayList<String>();
		handlerPropertyMap = new HashMap<String, PropertyData>();
		methodTypes = CAppEnvironment.getRegistryHandler().getFilterMethods();
		Label lblHandlerPropertyInfo = new Label(container, SWT.NONE);
		lblHandlerPropertyInfo.setBounds(10, 10, 188, 13);
		lblHandlerPropertyInfo.setText("Handler Properties Info");
		
		handlerPropertiesTable = new Table(container,  SWT.BORDER | 
				   SWT.V_SCROLL | 
				   SWT.MULTI | 
				   SWT.FULL_SELECTION);
		handlerPropertiesTable.setHeaderVisible(true);
		handlerPropertiesTable.setLinesVisible(true);
		GridData data = new GridData(SWT.LEFT, SWT.FILL, true, false);
		data.heightHint = 100;
		data.horizontalSpan = 3;
		handlerPropertiesTable.setLayoutData(data);
		
		
		handlerPropertiesTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (handlerPropertiesTable.getSelection().length>0){
					btnRemove.setEnabled(true);	 
				} else{
					btnRemove.setEnabled(false);	 
				}
			}
		});
		
		TableLayout handlerProptableLayout = new TableLayout();
		handlerPropertiesTable.setLayout(handlerProptableLayout);
		
		handlerProptableLayout.addColumnData(new ColumnWeightData(10, 150, true));
		TableColumn column = new TableColumn(handlerPropertiesTable, SWT.NONE);
		column.setText(TITLES[0]);
		column.setAlignment(SWT.LEFT);
		
		handlerProptableLayout.addColumnData(new ColumnWeightData(15, 450, true));
		column = new TableColumn(handlerPropertiesTable, SWT.NONE);
		column.setText(TITLES[1]);
		column.setAlignment(SWT.LEFT);
		
		handlerProptableLayout.addColumnData(new ColumnWeightData(20, 120, true));
		column = new TableColumn(handlerPropertiesTable, SWT.NONE);
		column.setText(TITLES[2]);
		column.setAlignment(SWT.LEFT);
		
		viewer = new TableViewer(handlerPropertiesTable);
		viewer.setColumnProperties(TITLES);
		viewer.setContentProvider(new HandlerPropertyContentProvider());
		viewer.setLabelProvider(new HandlerPropertyLabelProvider());
		
		CellEditor[] editors = new CellEditor[3];
		editors[0] = new TextCellEditor(handlerPropertiesTable);
		editors[1] = new TextCellEditor(handlerPropertiesTable);
		editors[2] = new ComboBoxCellEditor(handlerPropertiesTable, handlerTypes, SWT.READ_ONLY);
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new HandlerPropertyTableCellModifier());
		
		GridData gdBtnRemove = new GridData(SWT.RIGHT, SWT.FILL, true, false);
		gdBtnRemove.horizontalSpan=3;
		gdBtnRemove.horizontalIndent=30;
		gdBtnRemove.widthHint=100;
		gdBtnRemove.heightHint=27;
		
		btnRemove = new Button(container, SWT.NONE);
		btnRemove.setText("Remove");
		btnRemove.setLayoutData(gdBtnRemove);
		btnRemove.setEnabled(false);
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (handlerPropertiesTable.getSelectionIndex() != -1) {
					TableItem[] selection = handlerPropertiesTable.getSelection();
					for (TableItem item : selection) {
						if(null!=item.getText(0)){
							handlerPropertyMap.remove(item.getText(0));
						}
					}
					handlerPropertiesTable.remove(handlerPropertiesTable.getSelectionIndices());
				}
				
			}
		});
		
		GridData gdLabelRemove = new GridData();
		gdLabelRemove.horizontalSpan=3;
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Handler Methods");
		lblNewLabel.setLayoutData(gdLabelRemove);
		
		handlerMethodsTable = new Table(container, 
										SWT.BORDER | 
										SWT.V_SCROLL | 
										SWT.MULTI | 
										SWT.FULL_SELECTION|
										SWT.CHECK);

		handlerMethodsTable.setLinesVisible(true);
		gd = new GridData(GridData.FILL_HORIZONTAL);
//		gd.widthHint = 475;
		gd.heightHint = 100;
		gd.horizontalSpan=3;
		handlerMethodsTable.setLayoutData(gd);
//		handlerMethodsTable.setEnabled(false);
		
		TableLayout tableLayout = new TableLayout();
		handlerMethodsTable.setLayout(tableLayout);
		
		loadData();
		
		selectAllButton = new Button(container, SWT.PUSH);
		selectAllButton.setText("Select All");
		gd = new GridData();
		gd.widthHint = 150;
		gd.heightHint = 27;
		selectAllButton.setLayoutData(gd);
		
		deSelectAllButton  = new Button(container, SWT.PUSH);
		deSelectAllButton.setText("Deselect All");
		gd = new GridData();
		gd.widthHint = 150;
		gd.heightHint = 27;
		deSelectAllButton.setLayoutData(gd);
		
		selectAllButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				ArrayList<String> tempMethodList = new ArrayList<String>();
				for (int i = 0; i < methodTypes.length; i++) {
					TableItem item = handlerMethodsTable.getItem(i);
					item.setChecked(true);
				}
				for(String method: methodTypes){
					if(!tempMethodList.contains(method)){
						tempMethodList.add(method);
					}
				}
				setSelectedMethods(tempMethodList);
			}
		});
		
		deSelectAllButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				for (int i = 0; i < methodTypes.length; i++) {
					TableItem item = handlerMethodsTable.getItem(i);
					item.setChecked(false);
				}
				ArrayList<String> tempMethodList = new ArrayList<String>();
				setSelectedMethods(tempMethodList);

			}
		});
		
		handlerMethodsTable.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {

				if (event.detail == SWT.CHECK) {
					if (((org.eclipse.swt.widgets.TableItem) event.item)
							.getChecked() == true) {
						String name = ((org.eclipse.swt.widgets.TableItem) event.item)
								.getText();

						if (!selectedMethods.contains(name)) {
							selectedMethods.add(name);
						}

					} else {
						String name = ((org.eclipse.swt.widgets.TableItem) event.item)
								.getText();
						if (!selectedMethods.contains(name)) {
							selectedMethods.remove(name);
						}
					}

				}
				setSelectedMethods(selectedMethods);
			}
		});
		
		loadHandlerMethodTaleData();
		setControl(container);
	}
	
	private void loadHandlerMethodTaleData(){
		handlerPropertiesTable.removeAll();
		for (String property : handlerPropertyMap.keySet()) {
			TableItem item = new TableItem(handlerPropertiesTable, SWT.NONE);
			PropertyData propDate = handlerPropertyMap.get(property);
			HandlerPropertyData handlerData = HandlerPropertyData.getHandlerData(property,propDate.data, propDate.type.name());
			item.setText(new String[] { handlerData.propertyName, handlerData.propertyValue });
			item.setData(handlerData);
		}
		addHandlerProperty();
	}
	
	public void loadData(){
		handlerMethodsTable.removeAll();
		handlerMethodsTable.setVisible(true);
//		selectAllButton.setVisible(true);
//		deSelectAllButton.setVisible(true);

		for (int i = 0; i < methodTypes.length; i++) {
			TableItem item = new TableItem(handlerMethodsTable, SWT.NONE);
			item.setText(methodTypes[i]);
		}
	}
	
	public void addHandlerProperty() {
		HandlerPropertyData handlerPropertyData = HandlerPropertyData.getHandlerData("", "", "");
		viewer.add(handlerPropertyData);
		TableItem item = handlerMethodsTable.getItem(handlerMethodsTable.getItemCount() - 1);
		item.setData(handlerPropertyData);
		handlerMethodsTable.setTopIndex(handlerMethodsTable.getItemCount());
		viewer.editElement(handlerPropertyData, 0);
	}
	
	private boolean validateXML(String xmlString){
		try{
			OMElement root = OMAbstractFactory.getOMFactory().createOMElement(new QName("root"));
			OMElement element = AXIOMUtil.stringToOM(xmlString);
			root.addChild(element);
		}catch (Exception e) {
			MessageDialog.openError(getShell(), "Registry Handler Artifact", "Property value should be well formatted XML string for Type XML");
			return false;
		}
		return true;
	}
	
	public HashMap<String, PropertyData> getHandlerPropertyMap() {
		return handlerPropertyMap;
	}

	public void setHandlerPropertyMap(HashMap<String, PropertyData> handlerPropertyMap) {
		this.handlerPropertyMap = handlerPropertyMap;
	}
	
	public ArrayList<String> getSelectedMethods() {
		return selectedMethods;
	}

	public void setSelectedMethods(ArrayList<String> selectedMethods) {
		this.selectedMethods = selectedMethods;
	}
	
	public class HandlerPropertyContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object parent) {
			handlerPropertyMap = new HashMap<String, PropertyData>();
			loadData();
			
			ArrayList results = new ArrayList();
			if (parent instanceof HandlerPropertyData) {
				results.add((HandlerPropertyData) parent);
			}
			return results.toArray();
		}

		public void dispose() {
			
		}

		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
			
		}
		
	}
	
	public class HandlerPropertyLabelProvider extends LabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object arg0, int arg1) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			HandlerPropertyData row = (HandlerPropertyData) element;
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
	
	class HandlerPropertyTableCellModifier implements ICellModifier {

		public boolean canModify(Object arg0, String arg1) {
			return true;
		}

		public Object getValue(Object element, String property) {
			Object result = null;
			HandlerPropertyData row = (HandlerPropertyData) element;
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
				String[] choices = handlerTypes;
				int i = choices.length - 1;
				while (!result.equals(choices[i]) && i > 0){
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
			HandlerPropertyData row = (HandlerPropertyData) tableItem.getData();

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
				String ctype = handlerTypes[((Integer) value).intValue()].trim();
				if (!row.type.equals(ctype)) {
					row.type = ctype;
				}
				break;
//				String ctype = (String) value;
//				if (ctype.length() > 0) {
//					row.type = ctype;
//				}
//				break;
			}
			if (row.isBlank()) {
				if (tableItem != handlerMethodsTable.getItem(handlerMethodsTable.getItemCount() - 1)) {
				}
			} else {
				TableItem item = handlerMethodsTable.getItem(handlerMethodsTable.getItemCount() - 1);
				HandlerPropertyData lastFilterData = (HandlerPropertyData) item.getData();
				if (!lastFilterData.isBlank()){
					addHandlerProperty();
				}
			}
			viewer.update(row, null);
			if(row.propertyName != null && !row.propertyName.equals("") && row.propertyValue != null && !row.propertyValue.equals("")){
				PropertyData prpData = new PropertyData(row.type.equalsIgnoreCase("xml")?DataType.XML:DataType.STRING, row.propertyValue);
				if(prpData.type.name().equals(DataType.XML.name())){
					if(validateXML(prpData.data)){
						handlerPropertyMap.put(row.propertyName, prpData);
						setHandlerPropertyMap(handlerPropertyMap);
					}
					
				}else{
					handlerPropertyMap.put(row.propertyName, prpData);
					setHandlerPropertyMap(handlerPropertyMap);
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
	
	
	
	public static class HandlerPropertyData {
		String propertyName; 
		String propertyValue;
		String type;
		String currentName;
		String currentValue;
		String cType;
		
		public static HandlerPropertyData getHandlerData(String cPropertyName, String cPropertyValue, String currentType){
			HandlerPropertyData handlerPropertyData = new HandlerPropertyData();
			handlerPropertyData.propertyName = cPropertyName;
			handlerPropertyData.propertyValue = cPropertyValue;
			handlerPropertyData.type = currentType;
			return handlerPropertyData;
		}
		
		public boolean isChanged() {
			return currentName == null || currentValue == null
					                   || !currentName.equals(propertyName) 
					                   || !currentValue.equals(propertyValue)
					                   || !cType.equals(type);
		}
		
		public boolean isBlank() {
			return propertyName.equals("") && propertyValue.equals("") && type.equals("");
		}
	}
}
