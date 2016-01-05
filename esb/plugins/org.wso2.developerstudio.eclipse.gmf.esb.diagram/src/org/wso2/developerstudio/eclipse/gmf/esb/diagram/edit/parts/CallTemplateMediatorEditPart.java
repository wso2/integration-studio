/*
 * Copyright (c) 2014-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SYNAPSE_CONFIG_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.TEMPLATE_RESOURCE_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.getActiveProject;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.CALLTEMPLATE_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
//import org.wso2.developerstudio.eclipse.artifact.template.validators.TemplateList;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
//import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.OpenSeparatelyEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.OpenEditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.CallTemplateMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.CallTemplateMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.ui.editor.Openable;
import org.wso2.developerstudio.eclipse.platform.ui.startup.ESBGraphicalEditor;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

/**
 * @generated NOT
 */
public class CallTemplateMediatorEditPart extends FixedSizedAbstractMediator {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3594;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	private static IDeveloperStudioLog log = Logger.getLog("org.wso2.developerstudio.eclipse.gmf.esb.diagram");

	/**
	 * @generated
	 */
	public CallTemplateMediatorEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CallTemplateMediatorItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CallTemplateMediatorCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenSeparatelyEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (EsbVisualIDRegistry.getVisualID(childView)) {
				case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
				case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new CallTemplateMediatorFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
					connectToMostSuitableElement();
					reAllocate(rect);
				}
			};
		};
	}

	/**
	 * @generated
	 */
	public CallTemplateMediatorFigure getPrimaryShape() {
		return (CallTemplateMediatorFigure) primaryShape;
	}

	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof CallTemplateMediatorDescriptionEditPart) {
			((CallTemplateMediatorDescriptionEditPart) childEditPart).setLabel(getPrimaryShape()
					.getCallTemplateMediatorDescriptionLabel());
			return true;
		}
		if (childEditPart instanceof CallTemplateMediatorInputConnectorEditPart) {
			IFigure borderItemFigure = ((CallTemplateMediatorInputConnectorEditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.WEST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		if (childEditPart instanceof CallTemplateMediatorOutputConnectorEditPart) {
			IFigure borderItemFigure = ((CallTemplateMediatorOutputConnectorEditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.EAST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		return false;
	}

	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof CallTemplateMediatorDescriptionEditPart) {
			return true;
		}
		if (childEditPart instanceof CallTemplateMediatorInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((CallTemplateMediatorInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof CallTemplateMediatorOutputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((CallTemplateMediatorOutputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new ToolbarLayout(true));
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	private ESBArtifact createArtifact(String name, String groupId, String version, String path, String type) {
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(type);
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	private String getMavenGroupID(IProject project) {
		String groupID = "com.example";
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile());
			groupID = mavenProject.getGroupId() + ".template";
		} catch (Exception e) {
			//ignore. Then group id would be default. 
		}

		return groupID;
	}

	private void addSequenceToArtifactXML(String templateName) {
		IProject activeProject = getActiveProject();
		ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
		try {
			esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation().toFile());
			esbProjectArtifact.addESBArtifact(createArtifact(templateName, getMavenGroupID(activeProject), "1.0.0",
					"src/main/synapse-config/templates/" + templateName + ".xml", "synapse/sequenceTemplate"));
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			log.error("Error while updating Artifact.xml");
		}
	}

	public boolean createAndOpenFile(String name, String fileURI1, String fileURI2, IProject currentProject) {
		IFile file = currentProject.getFile(TEMPLATE_RESOURCE_DIR + "/" + fileURI1);
		if (!file.exists()) {
			IFile fileTobeOpened = currentProject.getFile(SYNAPSE_CONFIG_DIR + "/templates/" + name + ".xml");
			try {
				if (fileTobeOpened.exists()) {
					OpenEditorUtils oeUtils = new OpenEditorUtils();
					oeUtils.openSeparateEditor(fileTobeOpened);
				} else {
					updatePom();
					addSequenceToArtifactXML(name);
					String path = fileTobeOpened.getParent().getFullPath() + "/";
					ArtifactTemplate sequenceArtifactTemplate = getTemplateArtifactTemplates()[0];
					String source = FileUtils.getContentAsString(sequenceArtifactTemplate.getTemplateDataStream());
					source = MessageFormat.format(source, name);
					fileTobeOpened.create(new ByteArrayInputStream(source.getBytes()), true,
							new NullProgressMonitor());
					Openable openable = ESBGraphicalEditor.getOpenable();
					openable.editorOpen(fileTobeOpened.getName(), ArtifactType.TEMPLATE_SEQUENCE.getLiteral(), path,
							source);
				}
			} catch (Exception e) {
				log.error("Cannot open file " + fileTobeOpened, e);
				return false;
			}
			return true;
		}

		else {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			try {
				page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				log.error("Cannot init editor", e);
			}
			return true;
		}
	}

	private ArtifactTemplate[] getTemplateArtifactTemplates() {
		Map<String,List<String>> filters=new HashMap<String,List<String>> ();
		DeveloperStudioProviderUtils.addFilter(filters,CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_SEQ_TEMPLATE);
		DeveloperStudioProviderUtils.addFilter(filters,CSProviderConstants.FILTER_MEDIA_TYPE,
				ESBMediaTypeConstants.MEDIA_TYPE_ENDPOINT_TEMPLATE);
		return ArtifactTemplateHandler.getArtifactTemplates(filters);
	}

	public void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = getActiveProject().getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-template-plugin")) {
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-template-plugin",
				ESBMavenConstants.WSO2_ESB_TEMPLATE_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("template");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	public void openWithSeparateEditor() {
		IProject activeProject = EditorUtils.getActiveProject();

		String name = ((CallTemplateMediator) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getElement()).getTargetTemplate();

		/*
		 * File creations.
		 */
		createAndOpenFile(name, "template_" + name + ".esb_diagram", "template_" + name + ".esb", activeProject);
		//EditorUtils.updateToolpalette();

	}

	public String calculateDefaultName() {
		IProject activeProject = EditorUtils.getActiveProject();
		String finalName = "Sequence_Template_1";
		int i = 1;

		try {
			while (ESBProjectUtils.artifactExists(activeProject, finalName)) {
				finalName = finalName.replaceAll("\\d+$", "");
				i++;
				finalName = finalName.concat(i + "");
			}
		} catch (Exception e) {
			finalName = finalName.concat("_").concat(RandomStringUtils.randomAlphabetic(5)).concat("_" + i);
		}
		return finalName;
	}

	public void createDialogBox() {

		final EObject callTemplate = (CallTemplateMediator) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getElement();

		// For validation: user should not enter "" value for name.
		if (((CallTemplateMediator) callTemplate).getTargetTemplate().trim().equals("")) {
			IInputValidator validator = new IInputValidator() {

				public String isValid(String str) {
					if (str.trim().isEmpty()) {
						return "Target Template cannot be empty";
					} else if (str.indexOf(0x20) != -1) {
						return "Target Template cannot contain spaces";
					}
					return null;
				}

			};
			String defaultName = calculateDefaultName();
			final InputDialog templateNameInput = new InputDialog(new Shell(), "Enter Target Template",
					"Target Template", defaultName, validator) {
				protected Control createDialogArea(Composite parent) {
					Composite composite = (Composite) super.createDialogArea(parent);
					return composite;
				}
			};
			int open = templateNameInput.open();
			if (open == Dialog.OK) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						String targetTemplate = templateNameInput.getValue();
						TransactionalEditingDomain editingDomain = getEditingDomain();

						SetRequest setRequest = new SetRequest(editingDomain, callTemplate, EsbPackage.eINSTANCE
								.getCallTemplateMediator_TargetTemplate(), targetTemplate);
						SetValueCommand operation = new SetValueCommand(setRequest) {

							public boolean canUndo() {
								return true;
							}

							public boolean canRedo() {
								return true;
							}
						};

						getEditDomain().getCommandStack().execute(new ICommandProxy(operation));

						openWithSeparateEditor();
					}
				});
			}
		} else {
			openWithSeparateEditor();
		}
	}

	/**
	 * @generated
	 */
	public class CallTemplateMediatorFigure extends EsbGraphicalShapeWithLabel {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureCallTemplateMediatorPropertyValue;

		private WrappingLabel callTemplateMediatorDescriptionLabel;

		/**
		 * @generated
		 */
		public CallTemplateMediatorFigure() {

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			fFigureCallTemplateMediatorPropertyValue = new WrappingLabel();
			fFigureCallTemplateMediatorPropertyValue
					.setText(DEFAULT_PROPERTY_VALUE_TEXT);
			fFigureCallTemplateMediatorPropertyValue.setAlignment(SWT.CENTER);
			callTemplateMediatorDescriptionLabel = getPropertyNameLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCallTemplateMediatorPropertyValue() {
			return fFigureCallTemplateMediatorPropertyValue;
		}

		public WrappingLabel getCallTemplateMediatorDescriptionLabel() {
			return callTemplateMediatorDescriptionLabel;
		}

		public String getIconPath() {
			return CALLTEMPLATE_MEDIATOR_ICON_PATH;
		}

		public String getNodeName() {
			return Messages.CallTemplateMediatorEditPart_NodeName;
		}

		public IFigure getToolTip() {
			if (StringUtils.isEmpty(toolTipMessage)) {
				return new Label(
						Messages.CallTemplateMediatorEditPart_ToolTipMessage);
			} else {
				return new Label(toolTipMessage);
			}
		}

	}
	
	

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 230, 230, 230);

}
