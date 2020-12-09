/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.esb.form.editors.article.views;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;

public class FormView extends ViewPart {
	private FormToolkit toolkit;
	private ScrolledForm form;
	/**
	 * The constructor.
	 */
	public FormView() {
	}
	/**
	 * This is a callback that will allow us to create the viewer and
	 * initialize it.
	 */
	public void createPartControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.setText(Messages.getString("FormView.title")); //$NON-NLS-1$
		TableWrapLayout layout = new TableWrapLayout();
		//GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);
		Hyperlink link = toolkit.createHyperlink(form.getBody(), Messages.getString("FormView.link"), //$NON-NLS-1$
				SWT.WRAP);
		link.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				System.out.println(Messages.getString("FormView.linkMessage")); //$NON-NLS-1$
			}
		});
		link.setText(Messages.getString("FormView.longLink")); //$NON-NLS-1$
		layout.numColumns = 2;
		TableWrapData td = new TableWrapData();
		td.colspan = 2;
		link.setLayoutData(td);
		//GridData gd = new GridData();
		//gd.horizontalSpan = 2;
		//link.setLayoutData(gd);
		toolkit.createLabel(form.getBody(), Messages.getString("FormView.textLabel")); //$NON-NLS-1$
		Text text = toolkit.createText(form.getBody(), ""); //$NON-NLS-1$
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		text.setLayoutData(td);
		//text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Button button = toolkit.createButton(form.getBody(),
				Messages.getString("FormView.checkbox"), SWT.CHECK); //$NON-NLS-1$
		td = new TableWrapData();
		td.colspan = 2;
		button.setLayoutData(td);

		//gd = new GridData();
		//gd.horizontalSpan = 2;
		//button.setLayoutData(gd);

		ExpandableComposite ec = toolkit.createExpandableComposite(form.getBody(), ExpandableComposite.TREE_NODE|ExpandableComposite.CLIENT_INDENT);
		ImageHyperlink eci = toolkit.createImageHyperlink(ec, SWT.NULL);
		//eci.setImage(FormArticlePlugin.getDefault().getImageRegistry().get(FormArticlePlugin.IMG_SAMPLE));
		ec.setTextClient(eci);
		ec.setText(Messages.getString("FormView.expandable")); //$NON-NLS-1$
		String ctext = Messages.getString("FormView.expandableText")+ //$NON-NLS-1$
		Messages.getString("FormView.expandablText2")+ //$NON-NLS-1$
		Messages.getString("FormView.expandableText3")+ //$NON-NLS-1$
		Messages.getString("FormView.expandableText4"); //$NON-NLS-1$
		Label client = toolkit.createLabel(ec, ctext, SWT.WRAP);
		ec.setClient(client);
		td = new TableWrapData();
		td.colspan = 2;
		ec.setLayoutData(td);
		ec.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		Section section = toolkit.createSection(form.getBody(), Section.DESCRIPTION|Section.TWISTIE|Section.TITLE_BAR|Section.EXPANDED);
		td = new TableWrapData(TableWrapData.FILL);
		td.colspan = 2;
		section.setLayoutData(td);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		section.setText(Messages.getString("FormView.stitle")); //$NON-NLS-1$
		section.setDescription(Messages.getString("FormView.sdesc")); //$NON-NLS-1$
		Composite sectionClient = toolkit.createComposite(section);
		sectionClient.setLayout(new GridLayout());
		button = toolkit.createButton(sectionClient, Messages.getString("FormView.radio1"), SWT.RADIO); //$NON-NLS-1$
		button = toolkit.createButton(sectionClient, Messages.getString("FormView.radio2"), SWT.RADIO); //$NON-NLS-1$
		section.setClient(sectionClient);

		StringBuffer buf = new StringBuffer();
		buf.append("<form>"); //$NON-NLS-1$
		buf.append("<p>"); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext1")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext2")); //$NON-NLS-1$
		buf.append("</p>"); //$NON-NLS-1$
		buf.append("<p>"); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext3")); //$NON-NLS-1$
		buf.append("</p>"); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext4")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext5")); //$NON-NLS-1$
		buf.append("</p>"); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext6")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext7")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext8")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext9")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext10")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext11")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext12")); //$NON-NLS-1$
		buf.append(Messages.getString("FormView.ftext13")); //$NON-NLS-1$
		buf.append("</form>"); //$NON-NLS-1$
		FormText rtext = toolkit.createFormText(form.getBody(), true);
		rtext.setWhitespaceNormalized(true);
		td = new TableWrapData(TableWrapData.FILL);
		td.colspan = 2;
		rtext.setLayoutData(td);
//		rtext.setImage("image", FormArticlePlugin.getDefault().getImageRegistry().get(FormArticlePlugin.IMG_SAMPLE)); //$NON-NLS-1$
		rtext.setColor("header", toolkit.getColors().getColor(FormColors.TITLE)); //$NON-NLS-1$
		rtext.setFont("header", JFaceResources.getHeaderFont()); //$NON-NLS-1$
		rtext.setFont("code", JFaceResources.getTextFont()); //$NON-NLS-1$
		rtext.setText(buf.toString(), true, false);
		rtext.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				System.out.println(Messages.getString("FormView.lmessage")+e.getHref()); //$NON-NLS-1$
			}
		});
		/*
		layout.numColumns = 3;
		Label label;
		TableWrapData td;
		
		label = toolkit.createLabel(form.getBody(), "Some text to put in the first column", SWT.WRAP);
		label = toolkit.createLabel(form.getBody() ,"Some text to put in the second column and make it a bit longer so that we can see what happens with column distribution. This text must be the longest so that it can get more space allocated to the columns it belongs to.", SWT.WRAP);
		td = new TableWrapData();
		td.colspan = 2;
		label.setLayoutData(td);
		label = toolkit.createLabel(form.getBody(), "This text will span two rows and should not grow the column.", SWT.WRAP);
		td = new TableWrapData();
		td.rowspan = 2;
		label.setLayoutData(td);
		label = toolkit.createLabel(form.getBody(), "This text goes into column 2 and consumes only one cell", SWT.WRAP);
		label.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		label = toolkit.createLabel(form.getBody(), "This text goes into column 3 and consumes only one cell too", SWT.WRAP);
		label.setLayoutData(new TableWrapData(TableWrapData.FILL));
		label = toolkit.createLabel(form.getBody(), "This text goes into column 2 and consumes only one cell", SWT.WRAP);
		label.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		label = toolkit.createLabel(form.getBody(), "This text goes into column 3 and consumes only one cell too", SWT.WRAP);
		label.setLayoutData(new TableWrapData(TableWrapData.FILL));
		form.getBody().setBackground(form.getBody().getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND)); */
		
		toolkit.paintBordersFor(form.getBody());
	}
	/**
	 * Passing the focus request to the form.
	 */
	public void setFocus() {
		form.setFocus();
	}
	/**
	 * Disposes the toolkit
	 */
	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}
}