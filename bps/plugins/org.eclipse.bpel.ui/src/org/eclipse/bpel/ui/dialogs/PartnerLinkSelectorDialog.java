/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameCommand;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.bpel.ui.util.NameDialog;
import org.eclipse.bpel.ui.util.NamespaceUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;

/**
 * Asks the user to select a partner.
 */
public class PartnerLinkSelectorDialog extends SelectionAndCreationDialog {

	protected static class PortTypeLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof PartnerLink) {
				PartnerLink partner = (PartnerLink)element;
				Role role = (partner.getMyRole() != null) ? partner.getMyRole() : partner.getPartnerRole();
				if (role != null) {
					PortType portType = ModelHelper.getPortType(role);
					if (portType != null) {
						QName qname = portType.getQName();
						String uri = NamespaceUtils.convertUriToNamespace(qname.getNamespaceURI());
						return uri + " - " + qname.getLocalPart(); //$NON-NLS-1$
					}
				}
			}
			return Messages.PartnerLinkSelectorDialog_0; 
		}
	}
	
	protected EObject modelObject;
	protected Text filterText;

	/**
	 * The modelObject represents the object which will hold the selected PartnerLink.
	 */
	public PartnerLinkSelectorDialog(Shell parent, EObject modelObject) {
		super(parent, new PropertiesLabelProvider(), new PortTypeLabelProvider());
		this.modelObject = modelObject;
		setTitle(Messages.PartnerLinkSelectorDialog_1); 
		setMessage(Messages.PartnerLinkSelectorDialog_2); 
		setUpperListLabel(Messages.PartnerLinkSelectorDialog_3); 
		setLowerListLabel(Messages.PartnerLinkSelectorDialog_4); 
		refreshPartners();
	}

	protected void refreshPartners() {
		PartnerLink[] partners = getPartnerLinks(modelObject);
		setElements(partners);
		if (fFilteredList != null) {
			setListElements(partners);
		}
	}
	
	/**
	 * Gets the partner links that can be applied to the model object.
	 */
	protected PartnerLink[] getPartnerLinks(EObject target) {
		PartnerLink[] partners = BPELUtil.getVisiblePartnerLinks(target);		
		List result = new ArrayList();
		for (int i = 0 ; i < partners.length; i++) {			
			if (isCompatible(target, partners[i])) {
				result.add(partners[i]);
			}
		}
		return (PartnerLink[])result.toArray(new PartnerLink[result.size()]);
	}

	/**
	 * Incompatible partners are the ones that do not have a role compatible
	 * with the target. If the partner has no roles defined yet it is
	 * considered compatible.
	 */
	protected boolean isCompatible(EObject target, PartnerLink partner) {
		if (partner.getMyRole() == null && partner.getPartnerRole() == null) return true;
		if (target instanceof Invoke && partner.getPartnerRole() != null) return true;
		if ((target instanceof Receive || target instanceof OnEvent || target instanceof OnMessage || target instanceof Reply) && partner.getMyRole() != null) return true;
		return false;
	}
	
	/**
	 * Returns the chosen variable or null.
	 */
	public PartnerLink getPartnerLink() {
		if (getResult().length > 0) {
			return (PartnerLink)getResult()[0];
		}
		return null;
	}

	@Override
	protected void handleNewButtonPushed() {
		PartnerLink partner = BPELFactory.eINSTANCE.createPartnerLink();
		Process process = BPELUtils.getProcess(modelObject);
		String newName = filterText.getText();
		newName = BPELUtil.generateUniqueModelName(process, newName, partner);
		NameDialog nameDialog = new NameDialog(getShell(), Messages.PartnerLinkSelectorDialog_5, Messages.PartnerLinkSelectorDialog_6, 
			newName, BPELUtil.getNCNameValidator());
		if (nameDialog.open() == Window.OK) {
			String newPartnerName = nameDialog.getValue();
			PartnerLinkType plt = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
			Definition artifactsDefinition = ModelHelper.getBPELEditor(process).getArtifactsDefinition();
			CompoundCommand command = new CompoundCommand();
			command.add(new InsertInContainerCommand(process, partner, null));
			command.add(ModelHelper.getCreatePartnerLinkTypeCommand(process, partner, plt, artifactsDefinition, getRoleKind()));
			command.add(new SetNameCommand(partner, newPartnerName));
			ModelHelper.getBPELEditor(process).getCommandStack().execute(command);
			refreshPartners();
			setFilter(partner.getName());
			setLowerSelectedElement(partner);
			
			// give focus to the dialog's OK button
			getOkButton().setFocus();
		}
	}
	
	/**
	 * Only used to get the Text instance.
	 */
	@Override
	protected Text createFilterText(Composite parent) {
		filterText = super.createFilterText(parent);
		return filterText;
	}

	protected int getRoleKind() {
		if (modelObject instanceof Invoke) {
			return ModelHelper.PARTNER_ROLE;
		}
		return ModelHelper.MY_ROLE;
	}
}
