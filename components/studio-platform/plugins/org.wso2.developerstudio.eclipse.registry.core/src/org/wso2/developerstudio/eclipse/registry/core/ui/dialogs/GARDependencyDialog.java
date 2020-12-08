package org.wso2.developerstudio.eclipse.registry.core.ui.dialogs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.core.Activator;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.GARFileType;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IGARImportDependency;
import org.wso2.developerstudio.eclipse.registry.core.ui.widgets.GRegImageUtils;
import org.wso2.developerstudio.eclipse.ui.image.OverlayImageDescriptor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class GARDependencyDialog extends Dialog {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private List<IGARImportDependency> garDependencies=new ArrayList<IGARImportDependency>();

	private Button btnSelectAll;

	private Button btnDeselectAll;

	private GARDependencyContentProvider garDependencyContentProvider;

	private CheckboxTreeViewer checkboxTreeViewer;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public GARDependencyDialog(Shell parentShell, IGARImportDependency...garDependencies) {
		super(parentShell);
		this.garDependencies.addAll(Arrays.asList(garDependencies));
	}

	private boolean isRootElement(Object o){
		return getGarDependencies().contains(o);
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		Label lblNewLabel = new Label(container, SWT.WRAP);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 2));
		lblNewLabel.setText("If you do not want the following WSDLs to be uploaded as governance untick/uncheck them.");
		
		checkboxTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);
		Tree tree = checkboxTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		garDependencyContentProvider = new GARDependencyContentProvider();
		checkboxTreeViewer.setContentProvider(garDependencyContentProvider);
		checkboxTreeViewer.setLabelProvider(new GARDependencyLabelProvider());
		checkboxTreeViewer.setInput(getGarDependencies());
		checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				if (element instanceof IGARImportDependency){
					IGARImportDependency dependency = (IGARImportDependency)element;
					dependency.setExclude(!event.getChecked());
					checkboxTreeViewer.setSubtreeChecked(dependency, event.getChecked());
					if (event.getChecked()){
						Map<IGARImportDependency, IGARImportDependency> parentMapper = garDependencyContentProvider.getParentMapper();
						while (parentMapper.containsKey(dependency)){
							dependency=parentMapper.get(dependency);
							checkboxTreeViewer.setChecked(dependency, true);
						}
					}
				}
				updateSelectButtons();
			}
		});
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		btnSelectAll = new Button(composite, SWT.NONE);
		btnSelectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				checkboxTreeViewer.setCheckedElements(garDependencyContentProvider.getAllElements().toArray());
				updateSelectButtons();
			}
		});
		btnSelectAll.setText("Select All");
		
		btnDeselectAll = new Button(composite, SWT.NONE);
		btnDeselectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				List<IGARImportDependency> allElements = garDependencyContentProvider.getAllElements();
				for (IGARImportDependency garImportDependency : allElements) {
					checkboxTreeViewer.setChecked(garImportDependency, false);
				}
				updateSelectButtons();
			}
		});
		btnDeselectAll.setText("Deselect All");
		updateTree();
		return container;
	}

	private void updateTree() {
		checkboxTreeViewer.refresh(true);
		checkboxTreeViewer.expandAll();
		checkboxTreeViewer.setCheckedElements(garDependencyContentProvider.getAllIncludedElements().toArray());
		List<IGARImportDependency> allExcludedElements = garDependencyContentProvider.getAllExcludedElements();
		for (IGARImportDependency excludedDependency : allExcludedElements) {
			checkboxTreeViewer.setChecked(excludedDependency, false);
			checkboxTreeViewer.setSubtreeChecked(excludedDependency, false);
		}
		checkboxTreeViewer.collapseAll();
		updateSelectButtons();
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	protected Point getInitialSize() {
		return new Point(556, 393);
	}


	public List<IGARImportDependency> getGarDependencies() {
		return garDependencies;
	}

	private void updateSelectButtons() {
		Object[] checkedElements = checkboxTreeViewer.getCheckedElements();
		btnDeselectAll.setEnabled(checkedElements.length>0);
		btnSelectAll.setEnabled(garDependencyContentProvider.getAllElements().size()!=checkedElements.length);
	}

	private class GARDependencyContentProvider implements ITreeContentProvider{
		private List<IGARImportDependency> allElements=new ArrayList<IGARImportDependency>();
		private Map<IGARImportDependency,IGARImportDependency> parentMapper=new HashMap<IGARImportDependency,IGARImportDependency>();
		
		public Object[] getChildren(Object o) {
			if (o instanceof List<?>){
				return ((List<?>)o).toArray();
			}else if (o instanceof IGARImportDependency){
				IGARImportDependency dependency=(IGARImportDependency)o;
				if (!getAllElements().contains(dependency)){
					getAllElements().add(dependency);
				}
				List<IGARImportDependency> children=new ArrayList<IGARImportDependency>();
				try {
					children.addAll(Arrays.asList(dependency.getWSDLImports()));
					children.addAll(Arrays.asList(dependency.getSchemaImports()));
					children.addAll(Arrays.asList(dependency.getSchemaIncludes()));
					children.addAll(Arrays.asList(dependency.getPolicyImports()));
				} catch (Exception e) {
					log.error(e);
				}
				for (IGARImportDependency importDependency : children) {
					parentMapper.put(importDependency, dependency);
				}
				return children.toArray();
			}
			return new Object[]{};
		}

		public Object getParent(Object o) {
			return null;
		}

		public boolean hasChildren(Object o) {
			return getChildren(o).length>0;
		}

		public Object[] getElements(Object o) {
			return getChildren(o);
		}

		public void dispose() {
		}

		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		}

		public List<IGARImportDependency> getAllElements() {
			return allElements;
		}
		
		public List<IGARImportDependency> getAllExcludedElements() {
			return getFilteredElements(false);
		}

		public List<IGARImportDependency> getAllIncludedElements() {
			return getFilteredElements(true);
		}
		
		private List<IGARImportDependency> getFilteredElements(boolean included) {
			boolean excluded=!included;
			List<IGARImportDependency> excludedElements=new ArrayList<IGARImportDependency>();
			for (IGARImportDependency dependency : getAllElements()) {
				if (dependency.isExclude()==excluded){
					excludedElements.add(dependency);
				}
			}
			return excludedElements;
		}

		public Map<IGARImportDependency,IGARImportDependency> getParentMapper() {
			return parentMapper;
		}
	}
	private enum SourceValidateState{
		NOT_VALIDATED,
		VALIDATING,
		VALID,
		INVALID
	}
	public static class GARURLValidatorForLabelProvider implements Runnable{
		GARDependencyLabelProvider lp;
		IGARImportDependency dependency;
		public GARURLValidatorForLabelProvider(GARDependencyLabelProvider lp, IGARImportDependency dependency) {
			this.lp=lp;
			this.dependency=dependency;
		}
		public void run() {
			try {
				dependency.getSource().openStream();
				lp.setValidState(dependency, true);
			} catch (IOException e) {
				lp.setValidState(dependency, false);
			}
		}
	}
	private class GARDependencyLabelProvider implements ILabelProvider{
		
		private Map<IGARImportDependency,SourceValidateState> validSource=new HashMap<IGARImportDependency, SourceValidateState>();
		
		public Image getImage(Object o) {
			ImageDescriptor imageDescriptor = null;
			if (o instanceof IGARImportDependency){
				IGARImportDependency dependency=(IGARImportDependency)o;
				String prefix="";
				if (!isRootElement(o)){
					prefix="import-";
				}
				if (dependency.getType()==GARFileType.WSDL){
					imageDescriptor = GRegImageUtils.getInstance().getImageDescriptor(prefix+"wsdl.png");
				}else if (dependency.getType()==GARFileType.SCHEMA_IMPORTS){
					imageDescriptor = GRegImageUtils.getInstance().getImageDescriptor(prefix+"xsd_obj.png");
				}else if (dependency.getType()==GARFileType.POLICY){
					if (validSource.containsKey(dependency)){
						
					}else{
						
					}
					imageDescriptor = GRegImageUtils.getInstance().getImageDescriptor(prefix+"policy.gif");
				}
				if (imageDescriptor!=null){
					if (isDependencyValidated(dependency)){
						if (!isDependencyValid(dependency)){
							imageDescriptor=new OverlayImageDescriptor(imageDescriptor,GRegImageUtils.getInstance().getImageDescriptor("error.png"));
						}
					}else{
						validate(dependency);
					}
				}
			}
			if (imageDescriptor==null){
				return null;
			}else{
				return imageDescriptor.createImage();
			}
		}
		
		private boolean isDependencyValidated(IGARImportDependency dependency){
			synchronized (validSource) {
				if (validSource.containsKey(dependency)){
					if (validSource.get(dependency)==SourceValidateState.NOT_VALIDATED || validSource.get(dependency)==SourceValidateState.VALIDATING){
						return false;
					}else{
						return true;
					}
				}else{
					return false;
				}
			}
		}

		private boolean isDependencyValid(IGARImportDependency dependency){
			synchronized (validSource) {
				return validSource.get(dependency)==SourceValidateState.VALID;
			}
		}
		
		private void validate(IGARImportDependency dependency){
			synchronized (validSource) {
				if (validSource.containsKey(dependency)){
					if (validSource.get(dependency)==SourceValidateState.VALIDATING){
						return;
					}
				}
				validSource.put(dependency,SourceValidateState.VALIDATING);
				new Thread(new GARURLValidatorForLabelProvider(this,dependency)).start();
			}
		}
		
		public void setValidState(IGARImportDependency dependency, boolean valid){
			synchronized (validSource) {
				dependency.setExclude(!valid);
				validSource.put(dependency,valid?SourceValidateState.VALID:SourceValidateState.INVALID);
			}
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					updateTree();
				}
			});
			
		}
		
		public String getText(Object o) {
			if (o instanceof IGARImportDependency){
				IGARImportDependency dependency=(IGARImportDependency)o;
				String fileName = FileUtils.getFileName(dependency.getSource());
				return fileName + " ("+dependency.getSource().toString()+")";
			}
			return null;
		}

		public void addListener(ILabelProviderListener arg0) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object arg0, String arg1) {
			return false;
		}

		public void removeListener(ILabelProviderListener arg0) {
		}
		
	}
}
