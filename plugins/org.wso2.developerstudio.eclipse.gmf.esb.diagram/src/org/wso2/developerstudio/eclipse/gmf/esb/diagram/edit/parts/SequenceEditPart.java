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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.REGISTRY_KEY_PROPERTY__KEY_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.SEQUENCE__NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.SEQUENCE__REFERRING_SEQUENCE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SEQUENCE_RESOURCE_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.SYNAPSE_CONFIG_DIR;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.SEQUENCE_MEDIATOR_ICON_PATH;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
//import org.wso2.developerstudio.eclipse.artifact.sequence.validators.SequenceTemplate;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediatorOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.OpenSeparatelyEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.SequenceStorage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.OpenEditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.SequenceCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.SequenceItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
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
public class SequenceEditPart extends FixedSizedAbstractMediator {

	private static IDeveloperStudioLog log = Logger.getLog("org.wso2.developerstudio.eclipse.gmf.esb.diagram"); //$NON-NLS-1$

	private EsbDiagramEditor mainDiagramEditorRef;

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3503;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	public static SequenceStorage sequenceStorage = new SequenceStorage();

	private static Integer sequenceCount = 0;

	private SequenceEditPart currentSequence;

	private String value;

	public static ArrayList<String> definedSequenceNames = new ArrayList<String>();

	private float inputCount = 0, outputCount = 0;

	private Button recieveCheckBox;
	//private boolean checked;
	private SequenceEditPart sequenceEditPart;
	private SequencesInfo info;

	/**
	 * @generated NOT
	 */
	public SequenceEditPart(View view) {
		super(view);
		sequenceEditPart = this;
		info = new SequencesInfo();
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new SequenceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new SequenceCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());

		// For handle Double click Event.
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenSeparatelyEditPolicy());

		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
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
				case SequenceInputConnectorEditPart.VISUAL_ID:
				case SequenceOutputConnectorEditPart.VISUAL_ID:
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

	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = ((ENotificationImpl) notification).getNotifier();
		if (notifier instanceof Sequence) {
			if (notification.getFeature() instanceof EReference) {
				if ("staticReferenceKey".equals(((EReference) notification.getFeature()).getName())) { //$NON-NLS-1$
					String keyValue = ((RegistryKeyProperty) notification.getNewValue()).getKeyValue();
					setValue((Sequence) notifier, SEQUENCE__NAME, keyValue);
				}
			} else if (notification.getFeature() instanceof EAttribute) {
				if ("name".equals(((EAttribute) notification.getFeature()).getName())) { //$NON-NLS-1$
					String name = (String) notification.getNewValue();
					if ("{XPath}".equals(name)) { //$NON-NLS-1$
						setValue((Sequence) notifier, SEQUENCE__REFERRING_SEQUENCE_TYPE, KeyType.DYNAMIC);
					} else {
						setValue((Sequence) notifier, SEQUENCE__REFERRING_SEQUENCE_TYPE, KeyType.STATIC);
						RegistryKeyProperty registryKeyProperty = ((Sequence) notifier).getStaticReferenceKey();
						setValue(registryKeyProperty, REGISTRY_KEY_PROPERTY__KEY_VALUE, name);
					}
				} else if ("referringSequenceType".equals(((EAttribute) notification.getFeature()).getName())) { //$NON-NLS-1$
					KeyType type = (KeyType) notification.getNewValue();
					if (KeyType.DYNAMIC == type) {
						setValue((Sequence) notifier, SEQUENCE__NAME, "{XPath}"); //$NON-NLS-1$
					} else {
						if ("{XPath}".equals(((Sequence) notifier).getName())) { //$NON-NLS-1$
							setValue((Sequence) notifier, SEQUENCE__NAME, ""); //$NON-NLS-1$
						}
					}
				}

			}
		}
	}

	private void setValue(EObject owner, EStructuralFeature feature, Object value) {
		SetCommand setCommand = new SetCommand(getEditingDomain(), owner, feature, value);
		if (setCommand.canExecute()) {
			getEditingDomain().getCommandStack().execute(setCommand);
		}
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new SequenceFigure() {
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
	public SequenceFigure getPrimaryShape() {
		return (SequenceFigure) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SequenceNameEditPart) {
			((SequenceNameEditPart) childEditPart).setLabel(getPrimaryShape().getSequenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof SequenceInputConnectorEditPart) {
			IFigure borderItemFigure = ((SequenceInputConnectorEditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.WEST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		if (childEditPart instanceof SequenceOutputConnectorEditPart) {
			IFigure borderItemFigure = ((SequenceOutputConnectorEditPart) childEditPart).getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.EAST, 0.5);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		return false;
	}

	/*public IFigure getFigure() {
		IFigure figure = super.getFigure();
		figure.setMaximumSize(new Dimension(75, 75));
		return figure;
	}*/

	/*protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(75, 75);
		result.setMinimumSize(new Dimension(75, 75));
		return result;
	}*/

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SequenceNameEditPart) {
			return true;
		}
		if (childEditPart instanceof SequenceInputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((SequenceInputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof SequenceOutputConnectorEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((SequenceOutputConnectorEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
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
	 * {@inheritDoc}
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		IFigure borderItemFigure = borderItemEditPart.getFigure();
		if (borderItemEditPart instanceof SequenceInputConnectorEditPart) {
			borderItemContainer.add(borderItemFigure, new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.WEST, 0.5));
		} else if (borderItemEditPart instanceof SequenceOutputConnectorEditPart) {
			borderItemContainer.add(borderItemFigure, new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
					PositionConstants.EAST, 0.5));
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
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

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(EsbVisualIDRegistry.getType(SequenceNameEditPart.VISUAL_ID));
	}

	public IProject getActiveProject() {
		IEditorPart editorPart = null;
		IProject activeProject = null;
		IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);

			if (editor != null) {
				editorPart = editor.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
			}

			if (editorPart != null) {
				EsbEditorInput input = (EsbEditorInput) editorPart.getEditorInput();
				IFile file = input.getXmlResource();
				activeProject = file.getProject();

			}
		}
		return activeProject;
	}

	private String getMavenGroupID(IProject project) {
		String groupID = "com.example"; //$NON-NLS-1$
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml").getLocation().toFile()); //$NON-NLS-1$
			groupID = mavenProject.getGroupId() + ".sequence"; //$NON-NLS-1$
		} catch (Exception e) {
			//ignore. Then group id would be default. 
		}

		return groupID;
	}

	private ESBArtifact createArtifact(String name, String groupId, String version, String path, String type) {
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(type);
		artifact.setServerRole("EnterpriseServiceBus"); //$NON-NLS-1$
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	public void openWithSeparateEditor() throws Exception {
		IProject activeProject = EditorUtils.getActiveProjectSafemode();

		String name = ((Sequence) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel()).getElement()).getName();
		//if (sequenceStorage.sequences.get(name) == null) {
		if (!name.equals("")) { //$NON-NLS-1$

			/*
			 * Tool group creations in the Tool pallete.
			 */

			/*			if ((getEditDomain().getPaletteViewer().getPaletteRoot().getChildren().size() - 2) != ToolPalleteDetails.SEQUENCE) {
			 getEditDomain().getPaletteViewer().getPaletteRoot().add(createSequenceGroup());
			 }

			 if (!definedSequenceNames.contains(name)) {
			 ((PaletteContainer) getEditDomain().getPaletteViewer().getPaletteRoot()
			 .getChildren().get(ToolPalleteDetails.SEQUENCE))
			 .add(createSequence4CreationTool(name));
			 definedSequenceNames.add(name);
			 }*/

		}

		/*
		 * File creations.
		 */
		createAndOpenFile(name, "sequence_" + name + ".esb_diagram", "sequence_" + name + ".esb", activeProject); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		//EditorUtils.updateToolpalette();

	}

	public boolean createAndOpenFile(String name, String fileURI1, String fileURI2, IProject currentProject) throws Exception {
		IFile file = currentProject.getFile(SEQUENCE_RESOURCE_DIR + "/" + fileURI1); //$NON-NLS-1$

		if (((Sequence) ((Node) sequenceEditPart.getModel()).getElement()).isReceiveSequence()) {
			info.setRecieveSequence(true);
			info.setAssociatedProxy(((ProxyService) ((Node) EditorUtils.getProxy(sequenceEditPart.getParent())
					.getModel()).getElement()).getName());
		}
		if (!file.exists()) {
			IFile fileTobeOpened = null;
			boolean registryProject = false;
			if(currentProject.hasNature("org.wso2.developerstudio.eclipse.general.project.nature")){ //$NON-NLS-1$
			     fileTobeOpened = currentProject.getFile(name + ".xml"); //$NON-NLS-1$
			     registryProject = true;
			}else{
				 fileTobeOpened = currentProject.getFile(SYNAPSE_CONFIG_DIR + "/sequences/" + name + ".xml"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
			if (fileTobeOpened.exists()) {
				OpenEditorUtils oeUtils = new OpenEditorUtils();
				oeUtils.openSeparateEditor(fileTobeOpened);
			} else {				
				if(registryProject){
					addSequenceToRegistryArtifactXML(name, currentProject);
				}else{
					addSequenceToArtifactXML(name);
					updatePom();
				}
				
				String path = fileTobeOpened.getParent().getFullPath() + "/"; //$NON-NLS-1$
				ArtifactTemplate sequenceArtifactTemplate = getSequenceTemplates()[0];
				String source = FileUtils.getContentAsString(sequenceArtifactTemplate.getTemplateDataStream());
				source = MessageFormat.format(source, name);
				fileTobeOpened
				.create(new ByteArrayInputStream(source.getBytes()), true, new NullProgressMonitor());
				Openable openable = ESBGraphicalEditor.getOpenable();
				openable.editorOpen(fileTobeOpened.getName(), ArtifactType.SEQUENCE.getLiteral(), path, source);
			}
			return true;
		}

		else {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			try {
				page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				log.error("Cannot init editor", e); //$NON-NLS-1$
			}
			return true;
		}
	}
	
	private void updatePom() throws IOException, XmlPullParserException {
		File mavenProjectPomLocation = getActiveProject().getFile("pom.xml").getLocation().toFile(); //$NON-NLS-1$
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-sequence-plugin")) { //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}

		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-sequence-plugin", //$NON-NLS-1$ //$NON-NLS-2$
				ESBMavenConstants.WSO2_ESB_SEQUENCE_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen"); //$NON-NLS-1$
		pluginExecution.setPhase("process-resources"); //$NON-NLS-1$
		pluginExecution.setId("sequence"); //$NON-NLS-1$

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation"); //$NON-NLS-1$
		artifactLocationNode.setValue("."); //$NON-NLS-1$
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList"); //$NON-NLS-1$
		typeListNode.setValue("${artifact.types}"); //$NON-NLS-1$
		pluginExecution.setConfiguration(configurationNode);
		plugin.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	private PaletteContainer createSequenceGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Sequences"); //$NON-NLS-1$
		paletteContainer.setId("Sequences"); //$NON-NLS-1$

		return paletteContainer;
	}

	private ToolEntry createSequence4CreationTool(String name) {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EsbElementTypes.Sequence_3503);
		/*types.add(EsbElementTypes.Sequence_3187);
		types.add(EsbElementTypes.Sequence_3254);
		types.add(EsbElementTypes.Sequence_3375);*/
		NodeToolEntry entry = new NodeToolEntry(name, "", types); //$NON-NLS-1$
		entry.setId("createSequence4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.Sequence_3503));
		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	public void createDialogBox() throws Exception {

		final EObject diagram = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getDiagram().getChildren().get(0)).getElement().eContainer();

		final EObject sequence = (Sequence) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel()).getElement();

		// For validation: user should not enter "" value for name.
		if (((Sequence) sequence).getName().trim().equals("")) { //$NON-NLS-1$
			IInputValidator validator = new IInputValidator() {

				public String isValid(String str) {
					if (str.trim().isEmpty()) {
						return "Sequence name cannot be empty"; //$NON-NLS-1$
					} else if (str.indexOf(0x20) != -1) {
						return "Sequence name cannot contain spaces"; //$NON-NLS-1$
					}
					return null;
				}

			};
			//String defaultName = "Sequence_" + (((EsbDiagram) diagram).getTest() + 1);
			String defaultName = calculateDefaultName();
			final InputDialog sequenceNameInput = new InputDialog(new Shell(), "Enter Sequence Name", "Sequence Name", //$NON-NLS-1$ //$NON-NLS-2$
					defaultName, validator) {
				protected Control createDialogArea(Composite parent) {
					Composite composite = (Composite) super.createDialogArea(parent);
					/*					recieveCheckBox = new Button(composite, SWT.CHECK);
					 recieveCheckBox.setText("Use this sequence as a Recieving sequence.");
					 recieveCheckBox.addSelectionListener(new SelectionListener() {

					 public void widgetSelected(SelectionEvent arg0) {
					 checked = recieveCheckBox.getSelection();
					 }

					 public void widgetDefaultSelected(SelectionEvent arg0) {

					 }
					 });*/
					return composite;
				}
			};
			int open = sequenceNameInput.open();
			if (open == Dialog.OK) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						String sequenceName = sequenceNameInput.getValue();
						TransactionalEditingDomain editingDomain = getEditingDomain();
						/*						SetRequest setRequestSequenceCount = new SetRequest(editingDomain, diagram,
						 EsbPackage.eINSTANCE.getEsbDiagram_Test(), ((EsbDiagram) diagram)
						 .getTest() + 1);
						 SetValueCommand operationSequenceCount = new SetValueCommand(
						 setRequestSequenceCount) {

						 public boolean canUndo() {
						 return true;
						 }

						 public boolean canRedo() {
						 return true;
						 }
						 };

						 ICommandProxy commandSequenceCount = new ICommandProxy(
						 operationSequenceCount);
						 if (commandSequenceCount.canExecute()) {
						 getEditDomain().getCommandStack().execute(commandSequenceCount);
						 }*/
		
						SetRequest setRequest = new SetRequest(editingDomain, sequence, EsbPackage.eINSTANCE
								.getSequence_Name(), sequenceName);
						SetValueCommand operation = new SetValueCommand(setRequest) {

							public boolean canUndo() {
								return true;
							}

							public boolean canRedo() {
								return true;
							}
						};

						getEditDomain().getCommandStack().execute(new ICommandProxy(operation));

						/*						if (checked) {
						 info.setRecieveSequence(true);
						 info.setAssociatedProxy(((ProxyService) ((Node) EditorUtils.getProxy(
						 sequenceEditPart.getParent()).getModel()).getElement())
						 .getName());
						 }*/

						/*						IProject activeProject = getActiveProject();
						 ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						 try {
						 esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml")
						 .getLocation().toFile());
						 esbProjectArtifact.addESBArtifact(createArtifact(sequenceName,
						 getMavenGroupID(activeProject), "1.0.0",
						 "src/main/synapse-config/sequences/" + sequenceName + ".xml",
						 "synapse/sequence"));
						 esbProjectArtifact.toFile();
						 } catch (Exception e) {
						 log.error("Error while updating Artifact.xml");
						 }*/
						try {
							openWithSeparateEditor();
						} catch (Exception e) {
							log.error("Cannot open sequence file ", e); //$NON-NLS-1$
							MessageDialog.openError(Display.getCurrent().getActiveShell(), "Cannot open sequence file ", //$NON-NLS-1$
									e.getLocalizedMessage());
						}
					}
				});
			}
		} else {
			openWithSeparateEditor();
		}
	}

	public String calculateDefaultName() {
		IProject activeProject = getActiveProject();
		String finalName = "Sequence_1"; //$NON-NLS-1$
		int i = 1;

		try {
			while (ESBProjectUtils.artifactExists(activeProject, finalName)) {
				finalName = finalName.replaceAll("\\d+$", ""); //$NON-NLS-1$ //$NON-NLS-2$
				i++;
				finalName = finalName.concat(i + ""); //$NON-NLS-1$
			}
		} catch (Exception e) {
			finalName = finalName.concat("_").concat(RandomStringUtils.randomAlphabetic(5)).concat("_" + i); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return finalName;
	}

	private void addSequenceToArtifactXML(String sequenceName) {
		IProject activeProject = getActiveProject();
		ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
		try {
			esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation().toFile()); //$NON-NLS-1$
			esbProjectArtifact.addESBArtifact(createArtifact(sequenceName, getMavenGroupID(activeProject), "1.0.0", //$NON-NLS-1$
					"src/main/synapse-config/sequences/" + sequenceName + ".xml", "synapse/sequence")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			log.error("Error while updating Artifact.xml",e); //$NON-NLS-1$
		}
	}
	
	private void addSequenceToRegistryArtifactXML(String sequenceName, IProject currentProject) {
		
		GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
		try {
			generalProjectArtifact.fromFile(currentProject.getFile("artifact.xml").getLocation().toFile()); //$NON-NLS-1$
			File pomLocation = currentProject.getFile("pom.xml").getLocation().toFile(); //$NON-NLS-1$
			MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
			RegistryArtifact artifact = new RegistryArtifact();
			artifact.setName(sequenceName);
			artifact.setVersion(mavenProject.getVersion());
			artifact.setType("registry/resource"); //$NON-NLS-1$
			artifact.setServerRole("GovernanceRegistry"); //$NON-NLS-1$
			artifact.setGroupId(mavenProject.getGroupId()+".resource"); //$NON-NLS-1$

			RegistryElement item = new RegistryItem();
			((RegistryItem) item).setFile(sequenceName + ".xml"); //$NON-NLS-1$
			((RegistryItem) item).setPath("/_system/governance/sequences"); //$NON-NLS-1$
			((RegistryItem) item).setMediaType("application/vnd.wso2.sequence"); //$NON-NLS-1$
			artifact.addRegistryElement(item);
			generalProjectArtifact.addArtifact(artifact);
			generalProjectArtifact.toFile();

		} catch (Exception e) {
			log.error("Error while updating Artifact.xml", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated NOT
	 */
	public class SequenceFigure extends EsbGraphicalShapeWithLabel {

		/**
		 * @generated
		 */
		private WrappingLabel fSequenceLabelFigure;

		/**
		 * @generated NOT
		 */
		public SequenceFigure() {

			/*
			 * GridLayout layoutThis = new GridLayout(); layoutThis.numColumns =
			 * 1; layoutThis.makeColumnsEqualWidth = true;
			 * this.setLayoutManager(layoutThis);
			 * 
			 * this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
			 * getMapMode().DPtoLP(8)));
			 */
			this.setBackgroundColor(THIS_BACK);
			createContents();

			/*
			 * this.addMouseListener(new MouseListener() {
			 * 
			 * public void mouseReleased(MouseEvent me) { // TODO Auto-generated
			 * method stub System.out.println("Released"); }
			 * 
			 * public void mousePressed(MouseEvent me) {
			 * //openWithSeparateEditor();
			 * 
			 * /*final EObject diagram =
			 * ((org.eclipse.gmf.runtime.notation.impl.NodeImpl)
			 * ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
			 * .getDiagram().getChildren().get(0)).getElement() .eContainer();
			 * String name = ((Sequence)
			 * ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
			 * .getElement()).getName(); if (sequenceStorage.sequences.get(name)
			 * == null) {
			 * 
			 * TransactionalEditingDomain editingDomain = getEditingDomain();
			 * SetRequest setRequest = new SetRequest(editingDomain, diagram,
			 * EsbPackage.eINSTANCE .getEsbDiagram_Test(), ((EsbDiagram)
			 * diagram).getTest() + 1); SetValueCommand operation = new
			 * SetValueCommand( setRequest) {
			 * 
			 * public boolean canUndo() { return true; }
			 * 
			 * public boolean canRedo() { return true; } };
			 * 
			 * getEditDomain().getCommandStack().execute( new
			 * ICommandProxy(operation));
			 * 
			 * sequenceStorage.sequences.put(name, ((EsbDiagram)
			 * diagram).getTest());
			 * 
			 * 
			 * // * Tool group creations in the Tool pallete.
			 * 
			 * 
			 * if ((getEditDomain().getPaletteViewer()
			 * .getPaletteRoot().getChildren().size() - 1) !=
			 * ToolPalleteDetails.SEQUENCE) {
			 * getEditDomain().getPaletteViewer().getPaletteRoot()
			 * .add(createSequenceGroup()); }
			 * 
			 * ((PaletteContainer) getEditDomain().getPaletteViewer()
			 * .getPaletteRoot().getChildren()
			 * .get(ToolPalleteDetails.SEQUENCE))
			 * .add(createSequence4CreationTool(name));
			 * 
			 * }
			 * 
			 * 
			 * // * File creations.
			 * 
			 * SequenceFileCreator sequenceFileCreator = new
			 * SequenceFileCreator();
			 * sequenceFileCreator.createFiles("sequence_" + name +
			 * ".sequence_diagram", "sequence_" + name + ".sequence");
			 * 
			 * 
			 * /* IFile file =
			 * ResourcesPlugin.getWorkspace().getRoot().getProject ("testing")
			 * .getFile("sequence"+sequenceStorage.sequences.
			 * get(currentSequence).toString()+".sequence_diagram");
			 * 
			 * if(!file.exists()){
			 * 
			 * createFiles(); try { file.create(null, IResource.NONE, null); }
			 * catch (CoreException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace(); } } file =
			 * ResourcesPlugin.getWorkspace().getRoot().getProject("testing" )
			 * .getFile("sequence"+sequenceStorage.sequences.get(
			 * currentSequence).toString()+".sequence_diagram");
			 * 
			 * IWorkbenchPage page = PlatformUI.getWorkbench()
			 * .getActiveWorkbenchWindow().getActivePage(); //System.out.
			 * println("xxxxxxxxxx"+sequenceStorage.sequences
			 * .get(currentSequence
			 * )+"     "+page.getActiveEditor().getEditorInput ().getName());
			 * HashMap map = new HashMap(); map.put(IMarker.LINE_NUMBER, new
			 * Integer(5)); map.put(IWorkbenchPage.EDITOR_ID_ATTR,
			 * "org.wso2.developerstudio.eclipse.gmf.esb.sequence.diagram.part.EsbDiagramEditorID"
			 * ); IMarker marker; try { marker =
			 * file.createMarker(IMarker.TEXT);
			 * 
			 * marker.setAttributes(map); // page.openEditor(marker); //2.1 API
			 * IDE.openEditor(page, marker); // 3.0 API marker.delete(); } catch
			 * (CoreException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 * 
			 * 
			 * }
			 * 
			 * public void mouseDoubleClicked(MouseEvent me) { // TODO
			 * Auto-generated method stub System.out.println("DoubleClicked");
			 * 
			 * }
			 * 
			 * });
			 */
		}

		private PaletteContainer createSequenceGroup() {
			PaletteDrawer paletteContainer = new PaletteDrawer("Sequences"); //$NON-NLS-1$
			paletteContainer.setId("Sequences"); //$NON-NLS-1$

			return paletteContainer;
		}

		private ToolEntry createSequence4CreationTool(String name) {
			NodeToolEntry entry = new NodeToolEntry(name, "", //$NON-NLS-1$
					Collections.singletonList(EsbElementTypes.Sequence_3503));
			entry.setId("createSequence4CreationTool"); //$NON-NLS-1$
			entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.Sequence_3503));
			entry.setLargeIcon(entry.getSmallIcon());

			return entry;
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			/*fSequenceLabelFigure = new WrappingLabel();
			fSequenceLabelFigure.setText("");
			fSequenceLabelFigure.setAlignment(PositionConstants.TOP | PositionConstants.CENTER);
			fSequenceLabelFigure.setFont(new Font(null, new FontData("Courier", 8, SWT.BOLD)));	
			this.getPropertyValueRectangle1().add(fSequenceLabelFigure);*/

			fSequenceLabelFigure = getPropertyNameLabel();
		}

		/*	*//**
				 * @generated NOT
				 */
		/*
		 * protected void fillShape(Graphics graphics) { // Backup the graphics
		 * colors Color bgColor = graphics.getBackgroundColor(); Color fgColor =
		 * graphics.getForegroundColor(); // Set the graphics color
		 * graphics.setBackgroundColor(getBackgroundColor());
		 * graphics.setForegroundColor(ColorConstants.white); // Restore the
		 * original colors graphics.fillGradient(getBounds(), true);
		 * graphics.setBackgroundColor(bgColor);
		 * graphics.setForegroundColor(fgColor); }
		 */

		/**
		 * @generated
		 */
		public WrappingLabel getSequenceLabelFigure() {
			return fSequenceLabelFigure;
		}

		public String getIconPath() {
			return SEQUENCE_MEDIATOR_ICON_PATH;
		}

		public String getNodeName() {
			return Messages.SequenceEditPart_NodeName;
		}

		public IFigure getToolTip() {
			if (StringUtils.isEmpty(toolTipMessage)) {
				return new Label(Messages.SequenceEditPart_ToolTip);
			} else {
				return new Label(toolTipMessage);
			}
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);

	/*
	 * This will be used for arrange the connectors to the right side of the figure.
	 */
	public void moveConnectorsRightSide() {

		for (int i = 0; i < this.getChildren().size(); ++i) {
			if (this.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart) {
				IFigure inputConnector = ((AbstractMediatorInputConnectorEditPart) this.getChildren().get(i))
						.getFigure();
				NodeFigure figureInput = ((AbstractMediatorInputConnectorEditPart) this.getChildren().get(i))
						.getNodeFigureInput();
				figureInput.removeAll();
				figureInput.add(((AbstractMediatorInputConnectorEditPart) this.getChildren().get(i))
						.getPrimaryShapeReverse());
				BorderItemLocator inputLocator = new FixedBorderItemLocator(this.getMainFigure(), inputConnector,
						PositionConstants.EAST, 0.30);

				this.getBorderedFigure().getBorderItemContainer().remove(inputConnector);
				this.getBorderedFigure().getBorderItemContainer().add(inputConnector, inputLocator);
			}
		}

		for (int i = 0; i < this.getChildren().size(); ++i) {
			if (this.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart) {
				IFigure outputConnector = ((AbstractMediatorOutputConnectorEditPart) this.getChildren().get(i))
						.getFigure();
				NodeFigure figureOutput = ((AbstractMediatorOutputConnectorEditPart) this.getChildren().get(i))
						.getNodeFigureOutput();
				figureOutput.removeAll();
				Figure emptyFigure = new Figure();
				figureOutput.add(emptyFigure);
				/*				figureOutput.add(((AbstractMediatorOutputConnectorEditPart) this.getChildren().get(
				 i)).getPrimaryShapeForward());*/
				BorderItemLocator outputLocator = new FixedBorderItemLocator(this.getMainFigure(), outputConnector,
						PositionConstants.EAST, 0.70);
				this.getBorderedFigure().getBorderItemContainer().remove(outputConnector);
				this.getBorderedFigure().getBorderItemContainer().add(outputConnector, outputLocator);
			}
		}

	}

	public static class NodeToolEntry extends PaletteToolEntry {

		private final List<IElementType> elementTypes;

		private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
			// super(title, description, null, null);
			super(null, title, null);
			this.setDescription(description);
			this.elementTypes = elementTypes;
		}

		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	public class SequencesInfo {
		private String associatedProxy;
		private boolean recieveSequence;

		public void setAssociatedProxy(String associatedProxy) {
			this.associatedProxy = associatedProxy;
		}

		public String getAssociatedProxy() {
			return associatedProxy;
		}

		public void setRecieveSequence(boolean recieveSequence) {
			this.recieveSequence = recieveSequence;
		}

		public boolean isRecieveSequence() {
			return recieveSequence;
		}
	}
	
	private ArtifactTemplate[] getSequenceTemplates() {
		Map<String,List<String>> filters=new HashMap<String,List<String>> ();
		DeveloperStudioProviderUtils.addFilter(filters,CSProviderConstants.FILTER_MEDIA_TYPE, ESBMediaTypeConstants.MEDIA_TYPE_SEQUENCE);
		return ArtifactTemplateHandler.getArtifactTemplates(filters);
	}

}
