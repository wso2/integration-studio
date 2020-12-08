package org.wso2.developerstudio.eclipse.platform.ui.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.superpom.SuperPomProvider;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.NewFolderDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;

import org.eclipse.emf.common.ui.CommonUIPlugin;


/**
 * @since 2.2.0
 */
public class WorkspaceResourceDialogExtended extends ElementTreeSelectionDialog implements ISelectionStatusValidator
{
  public static IContainer[] openFolderSelection(
    Shell parent,
    String title,
    String message,
    boolean allowMultipleSelection,
    Object[] initialSelection,
    List<ViewerFilter> viewerFilters)
  {
      WorkspaceResourceDialogExtended dialog = new WorkspaceResourceDialogExtended(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
    dialog.setAllowMultiple(allowMultipleSelection);
    dialog.setTitle(title != null ? title : CommonUIPlugin.INSTANCE.getString("_UI_FolderSelection_title"));
    dialog.setMessage(message);
    dialog.setShowNewFolderControl(false);

    dialog.addFilter(dialog.createDefaultViewerFilter(false));
    if (viewerFilters != null)
    {
      for (ViewerFilter viewerFilter : viewerFilters)
      {
        dialog.addFilter(viewerFilter);
      }
    }

    if (initialSelection != null)
    {
      dialog.setInitialSelections(initialSelection);
    }

    dialog.loadContents();
    
    return dialog.open() == Window.OK ? dialog.getSelectedContainers() : new IContainer [0];
  }

  public static IFile[] openFileSelection(
    Shell parent,
    String title,
    String message,
    boolean allowMultipleSelection,
    Object[] initialSelection,
    List<ViewerFilter> viewerFilters)
  {
      WorkspaceResourceDialogExtended dialog = new WorkspaceResourceDialogExtended(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
    dialog.setAllowMultiple(allowMultipleSelection);
    dialog.setTitle(title != null ? title : CommonUIPlugin.INSTANCE.getString("_UI_FileSelection_title"));
    dialog.setMessage(message);

    dialog.addFilter(dialog.createDefaultViewerFilter(true));
    if (viewerFilters != null)
    {
      for (ViewerFilter viewerFilter : viewerFilters)
      {
        dialog.addFilter(viewerFilter);
      }
    }

    if (initialSelection != null)
    {
      dialog.setInitialSelections(initialSelection);
    }

    dialog.loadContents();

    return dialog.open() == Window.OK ? dialog.getSelectedFiles() : new IFile [0];
  }

  public static IFile openNewFile(
    Shell parent, 
    String title, 
    String message, 
    IPath suggestedPath, 
    List<ViewerFilter> viewerFilters)
  {
      WorkspaceResourceDialogExtended dialog = new WorkspaceResourceDialogExtended(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
    dialog.setAllowMultiple(false);
    dialog.setTitle(title != null ? title : CommonUIPlugin.INSTANCE.getString("_UI_NewFile_title"));
    dialog.setMessage(message);
    dialog.setShowNewFolderControl(true);
    dialog.setShowFileControl(true);

    dialog.addFilter(dialog.createDefaultViewerFilter(false));
    if (viewerFilters != null)
    {
      for (ViewerFilter viewerFilter : viewerFilters)
      {
        dialog.addFilter(viewerFilter);
      }
    }

    if (suggestedPath != null)
    {
      IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      IResource resource = root.findMember(suggestedPath);
      if (resource != null && resource.isAccessible())
      {
        if (resource instanceof IContainer)
        {
          dialog.setInitialSelection(resource);
        }
        else
        {
          dialog.setInitialSelection(resource.getParent());
          dialog.setFileText(resource.getName());
        }
      }
      else
      {
        if (suggestedPath.segmentCount() > 1)
        {
          if (resource == null)
          {
            resource = root.getFile(suggestedPath);
          }
          
          if (resource.getProject().isAccessible())
          {
            IContainer container = resource.getParent();
            for (; !container.isAccessible() && container != resource.getProject(); container = container.getParent())
            {
              // Do nothing
            }
            dialog.setInitialSelection(container);
            suggestedPath = suggestedPath.removeFirstSegments(container.getFullPath().segmentCount());
            dialog.setFileText(suggestedPath.toString());
            suggestedPath = null;
          }
        }
        
        if (suggestedPath != null)
        {
          String fileText = suggestedPath.isAbsolute() ?
            suggestedPath.removeFirstSegments(1).toString() :
            suggestedPath.toString();
          dialog.setFileText(fileText);
        }
      }
    }

    dialog.loadContents();
    return dialog.open() == Window.OK ? dialog.getFile() : null;
  }

  protected boolean showNewFolderControl = false;
  protected boolean showFileControl = false;
  protected boolean showFiles = true;
  
  protected Button newFolderButton;
  protected Text fileText;
  protected String fileTextContent = "";

  protected IContainer selectedContainer;

  public WorkspaceResourceDialogExtended(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider)
  {
    super(parent, labelProvider, contentProvider);
    setComparator(new ResourceComparator(ResourceComparator.NAME));
    setValidator(this);
  }

  public void loadContents()
  {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    setInput(root);
  }

  public ViewerFilter createDefaultViewerFilter(boolean showFiles)
  {
    this.showFiles = showFiles;
    return new ViewerFilter()
      {
        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element)
        {
          if (element instanceof IResource)
          {
            IResource workspaceResource = (IResource)element;
            return workspaceResource.isAccessible()
              && (WorkspaceResourceDialogExtended.this.showFiles || workspaceResource.getType() != IResource.FILE);
          }
          return false;
        }
      };
  }

  @Override
  protected Control createDialogArea(Composite parent)
  {
    Composite composite = (Composite)super.createDialogArea(parent);
    
    
    if (isShowNewFolderControl())
    {
      createNewFolderControl(composite);
    }
    if (isShowFileControl())
    {
      createFileControl(composite);
    }

    applyDialogFont(composite);
    return composite;
  }
  
  protected void createNewFolderControl(Composite parent)
  {
    newFolderButton = new Button(parent, SWT.PUSH);
    newFolderButton.setText(CommonUIPlugin.INSTANCE.getString("_UI_NewFolder_label"));
    newFolderButton.addSelectionListener(new SelectionAdapter()
      {
        @Override
        public void widgetSelected(SelectionEvent event)
        {
          newFolderButtonPressed();
        }
      });
    newFolderButton.setFont(parent.getFont());
    updateNewFolderButtonState();
  }

  protected void updateNewFolderButtonState()
  {
    IStructuredSelection selection = (IStructuredSelection)getTreeViewer().getSelection();
    selectedContainer = null;
    if (selection.size() == 1)
    {
      Object first = selection.getFirstElement();
      if (first instanceof IContainer)
      {
        selectedContainer = (IContainer)first;
      }
    }
    newFolderButton.setEnabled(selectedContainer != null);
  }

  protected void newFolderButtonPressed()
  {
    NewFolderDialog dialog = new NewFolderDialog(getShell(), selectedContainer);
    if (dialog.open() == Window.OK)
    {
      TreeViewer treeViewer = getTreeViewer();
      treeViewer.refresh(selectedContainer);
      Object createdFolder = dialog.getResult()[0];
      treeViewer.reveal(createdFolder);
      treeViewer.setSelection(new StructuredSelection(createdFolder));
    }
  }

  protected void createFileControl(Composite parent)
  {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    {
      GridLayout layout = new GridLayout(2, false);
      layout.marginLeft = -5;
      layout.marginRight = -5;
      layout.marginTop = -5;
      layout.marginBottom = -5;
      composite.setLayout(layout);
    }

    Label fileLabel = new Label(composite, SWT.NONE);
    fileLabel.setText(CommonUIPlugin.INSTANCE.getString("_UI_FileName_label"));

    fileText = new Text(composite, SWT.BORDER);
    fileText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    fileText.addModifyListener(new ModifyListener()
      {
        public void modifyText(ModifyEvent e)
        {
          fileTextModified(fileText.getText());
        }
      });

    if (fileTextContent != null)
    {
      fileText.setText(fileTextContent);
    }
  }

  protected void fileTextModified(String text)
  {
    fileTextContent = text;
  }
  
  public IStatus validate(Object[] selectedElements)
  {
    if (isShowNewFolderControl())
    {
      updateNewFolderButtonState();
    }

    boolean enableOK = false;
    for (int i = 0; i < selectedElements.length; i++)
    {
      if (selectedElements[i] instanceof IContainer)
      {
        enableOK = !showFiles || (isShowFileControl() && fileText.getText().trim().length() > 0);
      }
      else if (selectedElements[i] instanceof IFile)
      {
        if (isShowFileControl())
        {
          fileText.setText(((IFile)selectedElements[i]).getName());
        }
        enableOK = true;
      }
      if (enableOK) break;
    }
    
    return enableOK ? 
      new Status(IStatus.OK, "org.eclipse.emf.common.ui", 0, "", null) : 
      new Status(IStatus.ERROR, "org.eclipse.emf.common.ui", 0, "", null);
  }
  
  public IContainer[] getSelectedContainers()
  {
    List<IContainer> containers = new ArrayList<IContainer>();
    Object[] result = getResult();
    for (int i = 0; i < result.length; i++)
    {
      if (result[i] instanceof IContainer)
      {
        containers.add((IContainer)result[i]);
      }
    }
    return containers.toArray(new IContainer [containers.size()]);
  }

  public IFile[] getSelectedFiles()
  {
    List<IFile> files = new ArrayList<IFile>();
    Object[] result = getResult();
    for (int i = 0; i < result.length; i++)
    {
      if (result[i] instanceof IFile)
      {
        files.add((IFile)result[i]);
      }
    }
    return files.toArray(new IFile[files.size()]);
  }

  public IFile getFile()
  {
    String file = getFileText();
    if (file.length() != 0)
    {
      Object[] result = getResult();
      if (result.length == 1)
      {
        if (result[0] instanceof IFile)
        {
          return (IFile)result[0];
        }
        else if (result[0] instanceof IContainer)
        {
          IContainer container = (IContainer)result[0];
          return container.getFile(new Path(file));
        }
      }
    }
    return null;
  }

  public void setFileText(String text)
  {
    if (text == null)
    {
      text = "";
    }

    if (fileText != null && !fileText.isDisposed())
    {
      fileText.setText(text);
    }
    else
    {
      fileTextContent = text;
    }
  }

  public String getFileText()
  {
    return fileText != null && !fileText.isDisposed() ? fileText.getText() : fileTextContent;
  }

  public boolean isShowNewFolderControl()
  {
    return showNewFolderControl;
  }

  public void setShowNewFolderControl(boolean showNewFolderControl)
  {
    this.showNewFolderControl = showNewFolderControl;
  }

  public boolean isShowFileControl()
  {
    return showFileControl;
  }

  public void setShowFileControl(boolean showFileControl)
  {
    this.showFileControl = showFileControl;
  }
}
