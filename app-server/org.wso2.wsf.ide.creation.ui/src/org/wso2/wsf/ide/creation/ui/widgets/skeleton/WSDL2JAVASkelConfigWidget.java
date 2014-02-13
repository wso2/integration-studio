/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
package org.wso2.wsf.ide.creation.ui.widgets.skeleton;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis2.util.URLProcessor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.command.internal.env.core.common.StatusUtils;
import org.eclipse.wst.command.internal.env.ui.widgets.SimpleWidgetDataContributor;
import org.eclipse.wst.command.internal.env.ui.widgets.WidgetDataEvents;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.wsf.ide.consumption.core.messages.WSASConsumptionUIMessages;
import org.wso2.wsf.ide.consumption.core.utils.WSDLPropertyReader;
import org.wso2.wsf.ide.core.context.WSASEmitterContext;
import org.wso2.wsf.ide.core.plugin.WebServiceWSASCorePlugin;
import org.wso2.wsf.ide.core.plugin.messages.WSASCoreUIMessages;
import org.wso2.wsf.ide.creation.core.data.DataModel;
import org.wso2.wsf.ide.creation.core.messages.WSASCreationUIMessages;
import org.wso2.wsf.ide.creation.ui.plugin.WebServiceWSASCreationUIPlugin;

public class WSDL2JAVASkelConfigWidget extends SimpleWidgetDataContributor{
	private static IDeveloperStudioLog log=Logger.getLog(WebServiceWSASCreationUIPlugin.PLUGIN_ID);

	private DataModel model;
	IStatus status = Status.OK_STATUS;

	//controls
	//check box for server side interface
	private Button generateServerSideInterfaceCheckBoxButton;
	private Button generateAllCheckBoxButton;
	private Button noBuildXmlCheckBoxButton;
	private Button noWSDLCheckBoxButton;
	private Button noMessageReceiverCheckBoxButton;
	private Button unpackDatabindingClasses;
	private Button switchOnUnwrapping;
	private Combo databindingTypeCombo;
	// Text box to have the portname
	private Combo portNameCombo;
	//Text box to have the service name
	private Combo serviceNameCombo;
	private WSDLPropertyReader reader;
	private List<QName> serviceQNameList = null;
	private Table namespace2packageTable = null;
	//Label holding the full qualified package name for generated code
	private Text packageText;
	//Checkbox to enable the generation of test case classes 
	// for the generated implementation of the webservice.
	Label      label, fillLabel, fillLabel1, fillLabel2, fillLabel3, fillLabel4, fillLabel5, fillLabel6;
	WSASEmitterContext context;


	public WSDL2JAVASkelConfigWidget( DataModel model )	{
		context = WebServiceWSASCorePlugin.getDefault().getWSASEmitterContext();
		this.model = model;  
	}

	public WidgetDataEvents addControls( Composite parent, final Listener statusListener ){
		Composite  mainComp = new Composite( parent, SWT.NONE );
		GridLayout layout   = new GridLayout();
		mainComp.setLayout(layout);

		layout.numColumns = 3;
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		mainComp.setLayoutData( gd );

		// service name
		label = new Label(mainComp, SWT.NULL);
		label.setText(WSASCreationUIMessages.LABEL_SERVICE_NAME_CAPTION);

		serviceNameCombo = new Combo(mainComp, SWT.DROP_DOWN | SWT.BORDER
				| SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		serviceNameCombo.setLayoutData(gd);
		serviceNameCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setServiceName(serviceNameCombo.getText());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// port name
		label = new Label(mainComp, SWT.NULL);
		label.setText(WSASCreationUIMessages.LABEL_PORTNAME);
		portNameCombo = new Combo(mainComp, SWT.DROP_DOWN | SWT.BORDER
				| SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		portNameCombo.setLayoutData(gd);
		portNameCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setPortName(portNameCombo.getText());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Databinding
		label = new Label(mainComp, SWT.NULL);
		label.setText(WSASCreationUIMessages.LABEL_DATABINDING_CAPTION);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		databindingTypeCombo = new Combo(mainComp, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
		databindingTypeCombo.setLayoutData(gd);
		fillDatabinderCombo();
		databindingTypeCombo.select(0);
		databindingTypeCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setDatabindingType(databindingTypeCombo.getText());
			};
			public void widgetDefaultSelected(SelectionEvent e) {
			};
		});

		// package name
		label = new Label(mainComp, SWT.NULL);
		label.setText(WSASCreationUIMessages.LABEL_PACKEGE_NAME);
		packageText = new Text(mainComp, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;

		packageText.setLayoutData(gd);
		packageText.setText(""); // get this text from the
		packageText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				model.setPackageText(packageText.getText());
			}
		});

		//filling label 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		fillLabel = new Label(mainComp, SWT.HORIZONTAL | SWT.NULL);

		//filling label 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		fillLabel2 = new Label(mainComp, SWT.HORIZONTAL | SWT.NULL);

		//filling label 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		fillLabel3 = new Label(mainComp, SWT.HORIZONTAL | SWT.NULL);

		//filling label 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		fillLabel4 = new Label(mainComp, SWT.HORIZONTAL | SWT.NULL);


		model.setServerXMLCheck(true);

		unpackDatabindingClasses = new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		unpackDatabindingClasses.setLayoutData(gd);
		unpackDatabindingClasses
						.setSelection(context.isUnpackDatabindingClasses());
		unpackDatabindingClasses.setText(WSASCreationUIMessages.
									  LABEL_UNPACK_DATABINDING_CLASSES);
		model.setUnpackDatabindingClasses(context.isUnpackDatabindingClasses());
		unpackDatabindingClasses.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setUnpackDatabindingClasses(
						unpackDatabindingClasses.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		switchOnUnwrapping= new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		switchOnUnwrapping.setLayoutData(gd);
		switchOnUnwrapping
						.setSelection(context.isSwitchOnUnwrapping());
		switchOnUnwrapping.setText(WSASCreationUIMessages.
									  LABEL_SWITCH_ON_UNWRAP);
		model.setUnpackDatabindingClasses(context.isSwitchOnUnwrapping());
		switchOnUnwrapping.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setSwitchOnUnwrapping(
						switchOnUnwrapping.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		//the server side interface option
		generateServerSideInterfaceCheckBoxButton = new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		generateServerSideInterfaceCheckBoxButton.setLayoutData(gd);
		generateServerSideInterfaceCheckBoxButton
						.setSelection(context.isServiceInterfaceSkeleton());
		generateServerSideInterfaceCheckBoxButton.setText(WSASCreationUIMessages.
									  LABEL_GENERATE_SERVERSIDE_INTERFACE);
		model.setGenerateAllCheck(context.isServiceInterfaceSkeleton());
		generateServerSideInterfaceCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setGenerateServerSideInterface(
						generateServerSideInterfaceCheckBoxButton.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// generate all
		generateAllCheckBoxButton = new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		generateAllCheckBoxButton.setLayoutData(gd);
		generateAllCheckBoxButton.setSelection(context.isServiceGenerateAll());
		generateAllCheckBoxButton.setText(WSASCreationUIMessages.LABEL_GENERATE_ALL);
		generateAllCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setGenerateAllCheck(generateAllCheckBoxButton.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		// no build xml
		noBuildXmlCheckBoxButton = new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		noBuildXmlCheckBoxButton.setLayoutData(gd);
		noBuildXmlCheckBoxButton.setSelection(context.isClientGenerateAll());
		noBuildXmlCheckBoxButton.setText(WSASConsumptionUIMessages.LABEL_NO_BUILD_XML);
		noBuildXmlCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setNoBuildXml(noBuildXmlCheckBoxButton.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		// no wsdl
		noWSDLCheckBoxButton = new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		noWSDLCheckBoxButton.setLayoutData(gd);
		noWSDLCheckBoxButton.setSelection(context.isClientGenerateAll());
		noWSDLCheckBoxButton.setText(WSASConsumptionUIMessages.LABEL_NO_WSDL);
		noWSDLCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setNoWSDL(noWSDLCheckBoxButton.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		// no message receiver
		noMessageReceiverCheckBoxButton = new Button(mainComp, SWT.CHECK);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		noMessageReceiverCheckBoxButton.setLayoutData(gd);
		noMessageReceiverCheckBoxButton.setSelection(context.isClientGenerateAll());
		noMessageReceiverCheckBoxButton.setText(WSASConsumptionUIMessages.LABEL_NO_MESSAGE_RECEIVER);
		noMessageReceiverCheckBoxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				model.setNoMessageReceiver(noMessageReceiverCheckBoxButton.getSelection());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		//filling label 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		fillLabel5 = new Label(mainComp, SWT.HORIZONTAL | SWT.NULL);

		//filling label 
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 3;
		fillLabel6 = new Label(mainComp, SWT.HORIZONTAL | SWT.NULL);
		
		//add a table to set namespace to package mapping
		gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 3;
        gd.verticalSpan = 5;
        
        namespace2packageTable = new Table(mainComp,SWT.BORDER|SWT.MULTI);
        namespace2packageTable.setLinesVisible(true);
        namespace2packageTable.setHeaderVisible(true); 
        namespace2packageTable.setEnabled(true);
        namespace2packageTable.setLayoutData(gd);
       
        declareColumn(namespace2packageTable,
        		350, //a default width until we adjust
        		WSASCreationUIMessages.LABEL_NAMESPACE);
        declareColumn(namespace2packageTable,
        		200,//a default width until we adjust
        		WSASCreationUIMessages.LABEL_PACKAGE);
        
        namespace2packageTable.setVisible(true);
        
        // add the table editor
        final TableEditor editor = new TableEditor(namespace2packageTable);
        editor.setColumn(1);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;

        namespace2packageTable.addListener(SWT.MouseDown, new Listener() {
            public void handleEvent(Event event) {
              Rectangle clientArea = namespace2packageTable.getClientArea();
              Point pt = new Point(event.x, event.y);
              int index = namespace2packageTable.getTopIndex();
              while (index < namespace2packageTable.getItemCount()) {
                boolean visible = false;
                final TableItem item = namespace2packageTable.getItem(index);
                for (int i = 0; i < namespace2packageTable.getColumnCount(); i++) {
                  Rectangle rect = item.getBounds(i);
                  if (rect.contains(pt)) {
                    final int column = i;
                    final Text text = new Text(namespace2packageTable, SWT.NONE);
                    Listener textListener = new Listener() {
                      public void handleEvent(final Event e) {
                        switch (e.type) {
                        case SWT.FocusOut:
                          item.setText(column, text.getText());
                          text.dispose();
                          break;
                        case SWT.Traverse:
                          switch (e.detail) {
                          case SWT.TRAVERSE_RETURN:
                            item
                                .setText(column, text
                                    .getText());
                          case SWT.TRAVERSE_ESCAPE:
                            text.dispose();
                            e.doit = false;
                          }
                          break;
                        }
                      }
                    };
                    text.addListener(SWT.FocusOut, textListener);
                    text.addListener(SWT.Traverse, textListener);
                    editor.setEditor(text, item, i);
                    text.setText(item.getText(i));
                    text.selectAll();
                    text.setFocus();
                    return;
                  }
                  if (!visible && rect.intersects(clientArea)) {
                    visible = true;
                  }
                }
                if (!visible)
                  return;
                index++;
              }
              model.setNamespaseToPackageMapping(getNs2PkgMapping());
            }
          });
        
        namespace2packageTable.addListener(SWT.MouseExit, new Listener() {
        	public void handleEvent(Event event) {
        		model.setNamespaseToPackageMapping(getNs2PkgMapping());
        	}
        });
        
		populateParamsFromWSDL();
		populateModel();

		return this;
	}

	private void populateModel() {
		model.setServiceName(serviceNameCombo.getText());
		model.setPortName(portNameCombo.getText());
		model.setPackageText(packageText.getText());
		model.setDatabindingType(databindingTypeCombo.getText());
		model.setGenerateAllCheck(generateAllCheckBoxButton.getSelection());
		model.setGenerateServerSideInterface(
				generateServerSideInterfaceCheckBoxButton.getSelection());
		model.setNamespaseToPackageMapping(getNs2PkgMapping());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.command.env.ui.widgets.WidgetContributor#getStatus()
	 */
	public IStatus getStatus() 
	{
		IStatus result = null;
		return result;
	}

	private void populatePackageName() {
		this.packageText.setText(reader.packageFromTargetNamespace());
	}

	/**
	 * populate the service and the port from the WSDL this needs to be public
	 * since the WSDLselection page may call this
	 */
	public void populateParamsFromWSDL() {
		if (reader == null)
			reader = new WSDLPropertyReader();
		try {
			String lname = model.getWsdlURI();
			if (!"".equals(lname.trim())) {

				reader.readWSDL(model.getWebProjectName(), lname);

				this.serviceQNameList = reader.getServiceList();
				if (!serviceQNameList.isEmpty()) {
					serviceNameCombo.removeAll();
					for (int i = 0; i < serviceQNameList.size(); i++) {
						// add the local part of the
						QName serviceQnameInstance = serviceQNameList.get(0);
//						Class QNameClass = ClassLoadingUtil
//										.loadClassFromAntClassLoader("javax.xml.namespace.QName");
//						Method GetLocalPartMethod  = QNameClass.getMethod("getLocalPart", null);
//						Object resultLocalPart = GetLocalPartMethod
//													.invoke(serviceQnameInstance, null);
						serviceNameCombo.add(serviceQnameInstance.getLocalPart());
					}
					;
					// select the first one as the default
					serviceNameCombo.select(0);

					// load the ports
					loadPortNames();

				} else {
					// service name list being empty means we are switching to
					// the interface mode
					if (serviceNameCombo!=null) serviceNameCombo.removeAll();
					if (portNameCombo!=null) portNameCombo.removeAll();

				}

				populatePackageName();

				//populate the namespacess
				loadNamespaces(reader.getDefinitionNamespaceMap());
			}
		} catch (Exception e) {
			if (e.getClass().getName().equals("javax.wsdl.WSDLException"))
			status = StatusUtils.errorStatus(
					NLS.bind(WSASCreationUIMessages.ERROR_INVALID_WSDL_FILE_READ_WRITEL,
							 new String[]{e.getLocalizedMessage()}), e);
		}
	}

	private void loadPortNames() {
		int selectionIndex = serviceNameCombo.getSelectionIndex();
		if (selectionIndex != -1) {
			java.util.List ports = reader.getPortNameList(serviceQNameList
					.get(selectionIndex));
			if (!ports.isEmpty()) {
				portNameCombo.removeAll();
				for (int i = 0; i < ports.size(); i++) {
					// add the local part of the
					portNameCombo.add(ports.get(i).toString());
				}
				portNameCombo.select(0);
			} else {
				// TODO error no ports found
			}
		}
	}

	/**
	 * Fill the combo with proper databinding names
	 */
	private void fillDatabinderCombo() {
		databindingTypeCombo.add(WSASCoreUIMessages.DATA_BINDING_ADB);
		databindingTypeCombo.add(WSASCoreUIMessages.DATA_BINDING_XMLBEANS);
		databindingTypeCombo.add(WSASCoreUIMessages.DATA_BINDING_JIBX);
		databindingTypeCombo.add(WSASCoreUIMessages.DATA_BINDING_NONE);
		databindingTypeCombo.select(0);
	}
	
	
	/**
	 * A util method to create a new column
	 * @param table
	 * @param width
	 * @param colName
	 */
	private void declareColumn(Table table, int width,String colName){
        TableColumn column = new TableColumn(table,SWT.NONE);
        column.setWidth(width);
        column.setText(colName);
    }
	
	/**
	 * Loads the namespaces
	 * @param namespaceMap
	 */
	private void loadNamespaces(Map namespaceMap){
		Iterator namespaces = namespaceMap.values().iterator();
		namespace2packageTable.removeAll();
        TableItem[] items = new TableItem[namespaceMap.size()]; // An item for each field
        int i = 0;
        while(namespaces.hasNext()){
        	
           items[i] = new TableItem(namespace2packageTable, SWT.NULL);
           String namespace = (String)namespaces.next();
           items[i].setText(0,namespace);
           items[i].setText(1,getPackageFromNamespace(namespace));
           i++;
        }
        namespace2packageTable.setVisible(true);
	}
	
	/**
	 * get the package to namespace mappings
	 * @return
	 */
	public String getNs2PkgMapping(){
		StringBuffer sb=new StringBuffer();
		TableItem[] items = namespace2packageTable.getItems();
		String packageValue; 
		for (int i=0;i<items.length;i++){
			packageValue = items[i].getText(1);
			if (packageValue!=null && !"".equals(packageValue)){
				sb.append(("".equals(sb.toString())?"":",")).append(items[i].getText(0)).append("=").append(packageValue);
			}
			
		}
		return "".equals(sb.toString())?null:sb.toString();
	}
	
	
	/**
	 * get the package derived by  Namespace
	 */
	public String getPackageFromNamespace(String namespace){
		
		String result = null;
		try {
			//Class URLProcessor = Class.forName("org.apache.axis2.util.URLProcessor");
//			Class URLProcessor = ClassLoadingUtil
//						.loadClassFromAntClassLoader("org.apache.axis2.util.URLProcessor");
//			Class parameterTypes[] = new Class[1];
//			parameterTypes[0] = String.class;
//			Method makePackageNameMethod = URLProcessor
//									.getMethod("makePackageName", parameterTypes);
//			Object args[] = new Object[1];
//			args[0] = namespace;
			result = URLProcessor.makePackageName(namespace);
		} catch (SecurityException e) {
			log.error(e);
//		} catch (NoSuchMethodException e) {
//			log.error(e);
//		} catch (IllegalArgumentException e) {
//			log.error(e);
//		} catch (IllegalAccessException e) {
//			log.error(e);
//		} catch (InvocationTargetException e) {
//			log.error(e);
		}
		return result;
	}

}
