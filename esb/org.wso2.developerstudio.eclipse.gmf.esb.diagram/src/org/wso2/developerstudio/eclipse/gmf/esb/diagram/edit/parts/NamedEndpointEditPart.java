package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractSequencesEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ComplexFiguredAbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.OpenSeparatelyEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.ToolPalleteDetails;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.OpenEditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart.NodeToolEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.NamedEndpointCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.NamedEndpointItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.REGISTRY_KEY_PROPERTY__KEY_VALUE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.SEQUENCE__NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.SEQUENCE__REFERRING_SEQUENCE_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils.*;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

/**
 * @generated NOT
 */
public class NamedEndpointEditPart extends ComplexFiguredAbstractEndpoint {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3660;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	public static ArrayList<String> definedEndpointsNames = new ArrayList<String>();

	private Combo endpointTypeCombo;
	private int selection;

	private static IDeveloperStudioLog log = Logger
			.getLog("org.wso2.developerstudio.eclipse.gmf.esb.diagram");

	/**
	 * @generated
	 */
	public NamedEndpointEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new NamedEndpointItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new NamedEndpointCanonicalEditPolicy());
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
				case NamedEndpointInputConnectorEditPart.VISUAL_ID:
				case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
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
		if (notifier instanceof NamedEndpoint) {
			if (notification.getFeature() instanceof EReference) {
				if ("staticReferenceKey".equals(((EReference) notification.getFeature()).getName())) {
					String keyValue = ((RegistryKeyProperty) notification.getNewValue())
							.getKeyValue();
					setValue((NamedEndpoint) notifier, NAMED_ENDPOINT__NAME, keyValue);
				}
			} else if (notification.getFeature() instanceof EAttribute) {
				if ("name".equals(((EAttribute) notification.getFeature()).getName())) {
					String name = (String) notification.getNewValue();
					if ("{XPath}".equals(name)) {
						setValue((NamedEndpoint) notifier, NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE,
								KeyType.DYNAMIC);
					} else {
						setValue((NamedEndpoint) notifier, NAMED_ENDPOINT__REFERRING_ENDPOINT_TYPE,
								KeyType.STATIC);
						RegistryKeyProperty registryKeyProperty = ((NamedEndpoint) notifier)
								.getStaticReferenceKey();
						setValue(registryKeyProperty, REGISTRY_KEY_PROPERTY__KEY_VALUE, name);
					}
				} else if ("referringEndpointType".equals(((EAttribute) notification.getFeature())
						.getName())) {
					KeyType type = (KeyType) notification.getNewValue();
					if (KeyType.DYNAMIC == type) {
						setValue((NamedEndpoint) notifier, NAMED_ENDPOINT__NAME, "{XPath}");
					} else {
						if ("{XPath}".equals(((NamedEndpoint) notifier).getName())) {
							setValue((NamedEndpoint) notifier, NAMED_ENDPOINT__NAME, "");
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
		return primaryShape = new NamedEndpointFigure() {
			public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
				super.setBounds(rect);
				if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
					getMostSuitableElementToConnect();
					reAllocate(rect);
				}
			};
		};
	}

	/**
	 * @generated
	 */
	public NamedEndpointFigure getPrimaryShape() {
		return (NamedEndpointFigure) primaryShape;
	}

	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof NamedEndpointNameEditPart) {
			((NamedEndpointNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureNamedEndPointNamePropertyLabel());
			return true;
		}
		if (childEditPart instanceof NamedEndpointInputConnectorEditPart) {
			double position;
			EObject parentEndpoint = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (childEditPart
					.getParent()).getModel()).getElement();
			if (((NamedEndpoint) parentEndpoint).getInputConnector().getIncomingLinks().size() != 0) {
				EObject source = ((NamedEndpoint) parentEndpoint).getInputConnector()
						.getIncomingLinks().get(0).getSource().eContainer();
				/*
				 * Position of input connector of the endpoint should be 0.5 inside ComplexEndpoints and Sequences. 
				 */
				/*				position = ((source instanceof ComplexEndpoints) || (source
				 .eContainer().eContainer() instanceof Sequences)) ? 0.5
				 : 0.25;*/
				position = 0.5;
			} else {
				/*				position = ((this.getParent().getParent().getParent() instanceof ComplexEndpointsEditPart) || (this
				 .getParent().getParent().getParent() instanceof AbstractSequencesEditPart)) ? 0.5
				 : 0.25;*/
				position = 0.5;
			}
			IFigure borderItemFigure = ((NamedEndpointInputConnectorEditPart) childEditPart)
					.getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
					borderItemFigure, PositionConstants.WEST, position);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
			return true;
		}
		if (childEditPart instanceof NamedEndpointOutputConnectorEditPart) {
			IFigure borderItemFigure = ((NamedEndpointOutputConnectorEditPart) childEditPart)
					.getFigure();
			BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(),
					borderItemFigure, PositionConstants.WEST, 0.75);
			getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
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

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
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

	public void createDialogBox() {

		final EObject diagram = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getDiagram().getChildren().get(0)).getElement().eContainer();

		final EObject endpoint = (NamedEndpoint) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getElement();

		// For validation: user should not enter "" value for name.
		if ((((NamedEndpoint) endpoint).getName() == null)
				|| ((NamedEndpoint) endpoint).getName().trim().equals("")) {
			IInputValidator validator = new IInputValidator() {

				public String isValid(String str) {
					if (str.trim().isEmpty()) {
						return "Endpoint name cannot be empty";
					} else if (str.indexOf(0x20) != -1) {
						return "Endpoint name cannot contain spaces";
					}
					return null;
				}

			};
			/*			String defaultName = "Default"
			 + (((EsbDiagram) diagram).getTest() + 1);*/
			String defaultName = "Default";
			final InputDialog endpointNameInput = new InputDialog(new Shell(),
					"Enter Endpoint Name", "Endpoint Name", defaultName, validator) {
				protected Control createDialogArea(Composite parent) {
					Composite composite = (Composite) super.createDialogArea(parent);
					Label label = new Label(composite, SWT.WRAP);
					label.setText("Select endpoint type");
					GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL
							| GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_CENTER);
					label.setLayoutData(data);
					label.setFont(parent.getFont());

					endpointTypeCombo = new Combo(composite, SWT.SINGLE | SWT.BORDER);
					endpointTypeCombo.setItems(new String[] { "Default Endpoint",
							"Address Endpoint", "WSDL Endpoint", "Loadbalance Endpoint",
							"Failover Endpoint" });
					endpointTypeCombo.addSelectionListener(new SelectionListener() {
						public void widgetSelected(SelectionEvent arg0) {
							selection = endpointTypeCombo.getSelectionIndex();
						}

						public void widgetDefaultSelected(SelectionEvent arg0) {

						}
					});
					endpointTypeCombo.select(0);
					return composite;
				}
			};
			int open = endpointNameInput.open();
			if (open == Dialog.OK) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						String endpointName = endpointNameInput.getValue();
						TransactionalEditingDomain editingDomain = getEditingDomain();
						/*						SetRequest setRequestSequenceCount = new SetRequest(
						 editingDomain, diagram, EsbPackage.eINSTANCE
						 .getEsbDiagram_Test(),
						 ((EsbDiagram) diagram).getTest() + 1);
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
						 getEditDomain().getCommandStack().execute(
						 commandSequenceCount);
						 }*/

						SetRequest setRequest = new SetRequest(editingDomain, endpoint,
								EsbPackage.eINSTANCE.getNamedEndpoint_Name(), endpointName);
						SetValueCommand operation = new SetValueCommand(setRequest) {

							public boolean canUndo() {
								return true;
							}

							public boolean canRedo() {
								return true;
							}
						};

						getEditDomain().getCommandStack().execute(new ICommandProxy(operation));

						IProject activeProject = getActiveProject();
						ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
						try {
							esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml")
									.getLocation().toFile());
							esbProjectArtifact.addESBArtifact(createArtifact(endpointName,
									getMavenGroupID(activeProject), "1.0.0",
									"src/main/synapse-config/endpoints/" + endpointName + ".xml",
									"synapse/endpoint"));
							esbProjectArtifact.toFile();
						} catch (Exception e) {
							log.error("Error while updating Artifact.xml");
						}

						openWithSeparateEditor();
					}
				});
			}
		} else {
			openWithSeparateEditor();
		}
	}

	private IProject getActiveProject() {
		IEditorPart editorPart = null;
		IProject activeProject = null;
		IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getEditorReferences();
		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);

			if (editor != null) {
				editorPart = editor.getSite().getWorkbenchWindow().getActivePage()
						.getActiveEditor();
			}

			if (editorPart != null) {
				IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
				IFile file = input.getFile();
				activeProject = file.getProject();
			}
		}
		return activeProject;
	}

	private String getMavenGroupID(IProject project) {
		String groupID = "com.example";
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(project.getFile("pom.xml")
					.getLocation().toFile());
			groupID = mavenProject.getGroupId();
		} catch (Exception e) {
			//ignore. Then group id would be default. 
		}

		return groupID;
	}

	private ESBArtifact createArtifact(String name, String groupId, String version, String path,
			String type) {
		ESBArtifact artifact = new ESBArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType(type);
		artifact.setServerRole("EnterpriseServiceBus");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	public void openWithSeparateEditor() {
		IProject activeProject = getActiveProject();

		String name = ((NamedEndpoint) ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) getModel())
				.getElement()).getName();
		if (!name.equals("")) {

			/*
			 * Tool group creations in the Tool pallete.
			 */

			/*			if ((getEditDomain().getPaletteViewer().getPaletteRoot().getChildren().size() - 1) != ToolPalleteDetails.DEFINED_ENDPOINT) {
			 getEditDomain().getPaletteViewer().getPaletteRoot()
			 .add(createDefinedEndpointsGroup());
			 }

			 if (!definedEndpointsNames.contains(name)) {
			 ((PaletteContainer) getEditDomain().getPaletteViewer().getPaletteRoot()
			 .getChildren().get(ToolPalleteDetails.DEFINED_ENDPOINT))
			 .add(createNamedEndpoint6CreationTool(name));
			 definedEndpointsNames.add(name);
			 }*/

		}

		/*
		 * File creations.
		 */
		createFiles(name, "endpoint_" + name + ".esb_diagram", "endpoint_" + name + ".esb",
				activeProject);
		EditorUtils.updateToolpalette();

	}

	public boolean createFiles(String name, String fileURI1, String fileURI2,
			IProject currentProject) {
		Resource diagram;

		String basePath = "platform:/resource/" + currentProject.getName() + "/"
				+ ENDPOINT_RESOURCE_DIR + "/";
		IFile file = currentProject.getFile(ENDPOINT_RESOURCE_DIR + "/" + fileURI1);

		if (!file.exists()) {
			IFile fileTobeOpened = currentProject.getFile(SYNAPSE_CONFIG_DIR + "/endpoints/" + name
					+ ".xml");
			try {
				diagram = EsbDiagramEditorUtil.createDiagram(URI.createURI(basePath + fileURI1),
						URI.createURI(basePath + fileURI2), new NullProgressMonitor(), "endpoint",
						name, selection);

				if (fileTobeOpened.exists()) {
					String diagramPath = diagram.getURI().toPlatformString(true);
					OpenEditorUtils oeUtils = new OpenEditorUtils();
					oeUtils.openSeparateEditor(fileTobeOpened, diagramPath);
				} else {
					addEndpointToArtifactXML(name);
					EsbDiagramEditorUtil.openDiagram(diagram);
				}
				EsbDiagramEditorUtil.openDiagram(diagram);

			} catch (Exception e) {
				log.error("Cannot open file " + fileTobeOpened, e);
				return false;
			}
			return diagram != null;
		}

		else {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry()
					.getDefaultEditor(file.getName());
			try {
				page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				log.error("Cannot init editor", e);
			}
			return true;
		}
	}

	private PaletteContainer createDefinedEndpointsGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("DefinedEndpoints");
		paletteContainer.setId("DefinedEndpoints"); //$NON-NLS-1$

		return paletteContainer;
	}

	private ToolEntry createNamedEndpoint6CreationTool(String name) {
		NodeToolEntry entry = new NodeToolEntry(name, Messages.NamedEndpoint6CreationTool_desc,
				Collections.singletonList(EsbElementTypes.NamedEndpoint_3660));
		entry.setId("createNamedEndpoint6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EsbElementTypes.getImageDescriptor(EsbElementTypes.NamedEndpoint_3660));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
	
	private void addEndpointToArtifactXML(String endpointName) {
		IProject activeProject = getActiveProject();
		ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
		try {
			esbProjectArtifact.fromFile(activeProject.getFile("artifact.xml").getLocation()
					.toFile());
			esbProjectArtifact.addESBArtifact(createArtifact(endpointName,
					getMavenGroupID(activeProject), "1.0.0", "src/main/synapse-config/endpoints/"
							+ endpointName + ".xml", "synapse/endpoint"));
			esbProjectArtifact.toFile();
		} catch (Exception e) {
			log.error("Error while updating Artifact.xml");
		}
	}

	/**
	 * @generated NOT
	 */
	public class NamedEndpointFigure extends EsbGraphicalShapeWithLabel {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureNamedEndPointNamePropertyLabel;

		/**
		 * @generated
		 */
		public NamedEndpointFigure() {

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {
			fFigureNamedEndPointNamePropertyLabel = getPropertyNameLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNamedEndPointNamePropertyLabel() {
			return fFigureNamedEndPointNamePropertyLabel;
		}

		public String getIconPath() {
			return "icons/ico20/named-endpoint.gif";
		}

		public String getNodeName() {
			return "Named-EP";
		}

		public Color getBackgroundColor() {
			return THIS_BACK;
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

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 255, 255);

}
