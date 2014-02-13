package org.wso2.developerstudio.eclipse.humantask.editor.editors;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.eclipse.humantask.editor.Activator;
import org.wso2.tools.humantask.model.ht.HTFactory;
import org.wso2.tools.humantask.model.ht.HTPackage;
import org.wso2.tools.humantask.model.ht.THumanInteractions;
import org.wso2.tools.humantask.model.ht.TLogicalPeopleGroup;
import org.wso2.tools.humantask.model.ht.TLogicalPeopleGroups;


public class HumanInteractionsPage extends FormPage implements
		IResourceChangeListener {

	protected HTMultiPageEditor editor;
	protected EditingDomain domain;
	protected FormToolkit toolkit;
	protected THumanInteractions humanInteractions;
	TableViewer viewer;

	public HumanInteractionsPage(FormEditor editor,
			THumanInteractions humanInteractions) {
		super(editor, "HTHI", "Human Interactions");
		this.editor = (HTMultiPageEditor) editor;
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
				IResourceChangeEvent.POST_CHANGE);

		this.domain = this.editor.getEditingDomain();
		this.humanInteractions = humanInteractions;
	}
	
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Human Interactions");
		form.setBackgroundImage(Activator.getImageDescriptor("icons/form_banner.gif").createImage());
		TableWrapLayout layout = new TableWrapLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);

		// Logical People Groups Section
		creatLogicalPeopleGroupsSection(form, managedForm);
		createTasksSection(form);
		
	}
	
	private void creatLogicalPeopleGroupsSection(final ScrolledForm form, final IManagedForm managedForm) {
		Section section =
			toolkit.createSection(
				form.getBody(),
				Section.DESCRIPTION|Section.TITLE_BAR);		
		FormText rtext = toolkit.createFormText(section, false);
		section.setClient(rtext);
		//section.marginWidth = 10;
		//section.marginHeight = 5;
		//loadFormText(rtext, toolkit);		

		section.setText("Logical People Groups"); //$NON-NLS-1$
		section.setDescription("Specifies all logical people groups used in the enclosing human tasks and notifications."); //$NON-NLS-1$
		TableWrapData td = new TableWrapData();
		td.align = TableWrapData.FILL;
		td.grabHorizontal = true;
		section.setLayoutData(td);
		
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		
		Table t = toolkit.createTable(client, SWT.NULL);
		
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 60;
		gd.widthHint = 100;
		t.setLayoutData(gd);
		
		toolkit.paintBordersFor(client);
		
		Composite buttonsComposite = toolkit.createComposite(client, SWT.WRAP);
		GridLayout buttonsLayout = new GridLayout();
		buttonsLayout.numColumns = 1;
		buttonsLayout.marginHeight = 2;
		buttonsLayout.marginWidth = 2;
		buttonsComposite.setLayout(buttonsLayout);
		
		Button b = toolkit.createButton(buttonsComposite, "Add", SWT.PUSH); //$NON-NLS-1$
		
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		b.setLayoutData(gd);
		b.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(),"Human Task Editor",
              			"Please enter logical people group name","",null);
				if( dialog.open()== IStatus.OK){
					String value = dialog.getValue();
					TLogicalPeopleGroup logicalPeopleGroup = HTFactory.eINSTANCE.createTLogicalPeopleGroup();
					logicalPeopleGroup.setName(value);
					List<TLogicalPeopleGroup> list = new BasicEList<TLogicalPeopleGroup>();
					list.add(logicalPeopleGroup);
					Command addLogicalPeopleGroup= AddCommand.create(domain,
							humanInteractions.getLogicalPeopleGroups(), 
							HTPackage.eINSTANCE.getTLogicalPeopleGroups_LogicalPeopleGroup(), list);
					if(addLogicalPeopleGroup.canExecute()){
						domain.getCommandStack().execute(addLogicalPeopleGroup);
						viewer.refresh();
					}else {
						System.out.println("Cannot execute");
					}
				}
			}
		});
		
		Button editLPG = toolkit.createButton(buttonsComposite, "Edit", SWT.PUSH);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		editLPG.setLayoutData(gd);
		
		Button addParam = toolkit.createButton(buttonsComposite, "Add Parameter", SWT.PUSH);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		addParam.setLayoutData(gd);
		
		Button remParam = toolkit.createButton(buttonsComposite, "Remove Parameter", SWT.PUSH);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		remParam.setLayoutData(gd);
		
		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);
		
		viewer = new TableViewer(t);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		if(humanInteractions != null){
			viewer.setInput(humanInteractions);
		}else{
			System.out.println("Human Interactions Null.");
		}
	}
	
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			TLogicalPeopleGroups logicalPepleGroups = ((THumanInteractions)parent).getLogicalPeopleGroups();
			if(logicalPepleGroups != null){
				EList<TLogicalPeopleGroup> logicalPeopleGroupList = logicalPepleGroups.getLogicalPeopleGroup();
				return logicalPeopleGroupList.toArray(new TLogicalPeopleGroup[logicalPeopleGroupList.size()]);
			}
			
			return null;
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return ((TLogicalPeopleGroup)obj).getName();
		}

		public Image getColumnImage(Object obj, int index) {
			return null;
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}

		@Override
		public void addListener(ILabelProviderListener arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isLabelProperty(Object arg0, String arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	
	private void createTasksSection(final ScrolledForm form){
		Section section =
			toolkit.createSection(
				form.getBody(),
				Section.DESCRIPTION|Section.TITLE_BAR);		
		FormText rtext = toolkit.createFormText(section, false);
		section.setClient(rtext);
		//loadFormText(rtext, toolkit);		

		section.setText("Human Tasks"); //$NON-NLS-1$
		section.setDescription("Task definitions."); //$NON-NLS-1$
		TableWrapData td = new TableWrapData();
		td.align = TableWrapData.FILL;
		td.grabHorizontal = true;
		section.setLayoutData(td);
	}
	
	private void createNotificationSection(final ScrolledForm form){
		Section section =
			toolkit.createSection(
				form.getBody(),
				Section.DESCRIPTION|Section.TITLE_BAR);		
		FormText rtext = toolkit.createFormText(section, false);
		section.setClient(rtext);
		//loadFormText(rtext, toolkit);		

		section.setText("Notifications"); //$NON-NLS-1$
		section.setDescription("Notification definitions."); //$NON-NLS-1$
		TableWrapData td = new TableWrapData();
		td.align = TableWrapData.FILL;
		td.grabHorizontal = true;
		section.setLayoutData(td);
	}
	
	private void loadFormText(final FormText rtext, FormToolkit toolkit) {
		rtext.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				MessageDialog.openInformation(rtext.getShell(), "Eclipse Forms",  //$NON-NLS-1$
				"Link activated: href=" + e.getHref()); //$NON-NLS-1$
			}
		});
		rtext.setHyperlinkSettings(toolkit.getHyperlinkGroup());
		//rtext.setImage("image1", FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_LARGE)); //$NON-NLS-1$
		InputStream is = HumanInteractionsPage.class.getResourceAsStream("index.xml"); //$NON-NLS-1$
		if (is!=null) {
			rtext.setContents(is, true);
			try {
				is.close();
			}
			catch (IOException e) {
			}
		}
	}
	
	public void updateModel(THumanInteractions hiModel){
		humanInteractions = hiModel;
		viewer.setInput(humanInteractions);
		viewer.refresh();
	}

	@Override
	public void resourceChanged(IResourceChangeEvent arg0) {

	}

}
