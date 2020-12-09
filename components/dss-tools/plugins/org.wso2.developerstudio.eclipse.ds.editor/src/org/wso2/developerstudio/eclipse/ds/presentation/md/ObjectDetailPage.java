package org.wso2.developerstudio.eclipse.ds.presentation.md;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.eclipse.ds.CallQuery;
import org.wso2.developerstudio.eclipse.ds.ElementMapping;
import org.wso2.developerstudio.eclipse.ds.Query;
import org.wso2.developerstudio.eclipse.ds.presentation.DsEditor;

public class ObjectDetailPage implements IDetailsPage, IPartListener, ISelectionChangedListener {

	private Object input;
	private DsEditor editor;
	private AdapterFactory adapterFactory;
	private AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	private FormToolkit toolkit;
	private IManagedForm mform;
	private Composite detailsclient;
	private Section detailsection;
	private DetailSection sectionHolder;
	private boolean isCreateContentCalled;

	public ObjectDetailPage(Object key, DsEditor editor) {

		this.input = key;
		this.editor = editor;
		this.adapterFactory = this.editor.getAdapterFactory();
		this.adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(adapterFactory);

	}

	public void createContents(Composite parent) {

		isCreateContentCalled = true;

		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		layout.numColumns = 2;
		parent.setLayout(layout);

		toolkit = mform.getToolkit();
		detailsection = toolkit.createSection(parent, Section.DESCRIPTION);
		detailsection.marginWidth = 10;
		detailsection.setText(adapterFactoryItemDelegator.getText(input));
		detailsection.setDescription("Set the properties of the selected object.");
		TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.colspan = 2;
		td.grabHorizontal = true;
		detailsection.setLayoutData(td);

		toolkit.createCompositeSeparator(detailsection);
		detailsclient = toolkit.createComposite(detailsection);
		GridLayout glayout = new GridLayout();
		glayout.marginWidth = glayout.marginHeight = 0;
		glayout.numColumns = 2;
		glayout.horizontalSpacing = 100;
		detailsclient.setLayout(glayout);

		detailsPageSwitch(input);
		// add the client to the section
		detailsection.setClient(detailsclient);
		// add the section to the part
		final SectionPart spart = new SectionPart(detailsection);
		// add the part to the form
		mform.addPart(spart);

	}

	public void initialize(IManagedForm form) {
		this.mform = form;

	}

	private void detailsPageSwitch(Object input) {
		if (input != null) {
			// switch on input for specific details
			sectionHolder =
			                new DetailSection(toolkit, adapterFactoryItemDelegator, detailsclient,
			                                  input, editor);
			sectionHolder.createSection(input);
		} else {
			Label lb = new Label(detailsclient, SWT.NONE);
			lb.setText("No data Avilable");
		}
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void commit(boolean onSave) {
		// TODO Auto-generated method stub

	}

	public boolean setFormInput(Object input) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public boolean isStale() {
		// TODO Auto-generated method stub
		return false;
	}

	public void refresh() {
		// update();

	}

	public void selectionChanged(IFormPart part, ISelection selection) {

		IStructuredSelection ssel = (IStructuredSelection) selection;

		if (ssel.size() == 1) {

			input = (EObjectImpl) ssel.getFirstElement();

			// Fixing TOOLS-1004
			if ((input instanceof Query || input instanceof CallQuery) && !isCreateContentCalled) {

				if (detailsclient != null) {

					Control contrArr[] = detailsclient.getChildren();

					for (int i = 0; i < contrArr.length; i++) {

						contrArr[i].dispose();
					}

					detailsclient.layout();
					detailsPageSwitch(input);
					detailsclient.layout();
				}
			} else {

				isCreateContentCalled = false;

			}

		}

	}

	public void selectionChanged(SelectionChangedEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void partActivated(IWorkbenchPart arg0) {
		// TODO Auto-generated method stub

	}

	public void partBroughtToTop(IWorkbenchPart arg0) {
		// TODO Auto-generated method stub

	}

	public void partClosed(IWorkbenchPart arg0) {
		// TODO Auto-generated method stub

	}

	public void partDeactivated(IWorkbenchPart arg0) {
		// TODO Auto-generated method stub

	}

	public void partOpened(IWorkbenchPart arg0) {
		// TODO Auto-generated method stub

	}

}
