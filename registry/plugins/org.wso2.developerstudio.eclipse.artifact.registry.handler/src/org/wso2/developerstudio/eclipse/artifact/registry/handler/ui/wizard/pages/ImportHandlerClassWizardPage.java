package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.model.RegistryHandlerModel;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;

public class ImportHandlerClassWizardPage extends WizardPage{
	
	private String handlerClassName;
	private Combo existingHandlersCombo;
	private Map<String,List<String>> handlerClassesList=new HashMap<String, List<String>>();
	private List<String> existingHandlerClassesList;
	private RegistryHandlerModel regModel;
	
	public ImportHandlerClassWizardPage(String pageName, RegistryHandlerModel model) {
		super(pageName);
		setDescription("Import Handler Class from workspace");
		setTitle(pageName);
		existingHandlerClassesList = new ArrayList<String>();
		this.regModel = model;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		Label lblHandlerClass = new Label(container, SWT.NONE);
		lblHandlerClass.setText("Handler Class");
		lblHandlerClass.setBounds(10, 24, 100, 20);
		
		existingHandlersCombo = new Combo(container, SWT.NONE);
		existingHandlersCombo.setBounds(116, 17, 435, 27);
		
		existingHandlersCombo.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				if(existingHandlersCombo.getText() != null && !existingHandlersCombo.getText().equals("")){
					setHandlerClassName(existingHandlersCombo.getText());
					validate();
				}				
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		getAllHandlerClasses();
		fillComboBoxInfo(existingHandlerClassesList);
		if(regModel.getHandlerClassSeletionMethod().equals(Constants.IMPORT_HANDLER_CLASS_FROM_WS_TEXT)){
			validate();
		}
		if(existingHandlersCombo.getItemCount()>0) {
			if (existingHandlersCombo.getSelectionIndex()!=-1) {
				setPageComplete(true);
			} else {
				setPageComplete(false);
			}
		}
		else {
			setPageComplete(false);
		}
	}
	
	public List<String> getAllHandlerClasses(){
		determineHandlerClassProjects();
		for (String key: handlerClassesList.keySet()) {
			List<String> list = handlerClassesList.get(key);
			for (String fqn : list) {
				if(!existingHandlerClassesList.contains(list)){
					existingHandlerClassesList.add(fqn);
				}
			}
			
		}
		return existingHandlerClassesList;
	}
	
	
	
	private boolean isClassExtendedFromHandlerClass(IProject project, String fullyQualifiedClassName) throws JavaModelException{
		return JavaUtils.isClassExtendedFrom(project, fullyQualifiedClassName, Constants.HANDLER_SUPER_CLASSNAME);
	}
	
	public void determineHandlerClassProjects(){
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject prj : projects) {
			try {
	            if (!prj.isOpen() || !prj.hasNature(Constants.JAVA_NATURE_ID) ){
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
									if(type.getSuperclassName() != null){
										String[][] resolveType = type.resolveType(type.getSuperclassName());
										if(resolveType != null){
											String fullyQualifiedSuperClassName=(resolveType[0][0]).toString()+"."+(resolveType[0][1]).toString();
											if (isClassExtendedFromHandlerClass(prj, fullyQualifiedSuperClassName)){
												String fullyQualifiedName = type.getFullyQualifiedName();
												addHandlerClassProject(prj.getName(), fullyQualifiedName);
												regModel.getImportHandlerList().put(prj, fullyQualifiedName);
											}
										}
									}
								}
							}
//						}
					}
				}
			} catch (JavaModelException e) {
			}
		}
	}
	
	private void addHandlerClassProject(String projectName, String className){
		if (!handlerClassesList.containsKey(projectName)){
			handlerClassesList.put(projectName, new ArrayList<String>());
		}
		List<String> list=handlerClassesList.get(projectName);
		if(!list.contains(className)){
			list.add(className);
		}
	}

	public void setHandlerClassName(String handlerClassName) {
		this.handlerClassName = handlerClassName;
	}

	public String getHandlerClassName() {
		return handlerClassName;
	}
	
	public void fillComboBoxInfo(List<String> handlerClasses){
		existingHandlersCombo.removeAll();
		for(int i=0; i< handlerClasses.size(); i++){
			existingHandlersCombo.add(handlerClasses.get(i));
		}
//		serverClassesCombo.add("--Existing Class From Server--");
		if (existingHandlersCombo.getSelectionIndex() == -1) {
			existingHandlersCombo.select(0);
			setHandlerClassName(existingHandlersCombo.getText());
		}
	}
	
	public void validate(){
		if(existingHandlersCombo.getText() == null || existingHandlersCombo.getText().equals("") ){
			setErrorMessage("No handler classes in the workspace");
			setPageComplete(false);
		}else{
			setErrorMessage(null);
			setPageComplete(true);
		}
	}
}
