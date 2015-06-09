package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.part.DefaultDiagramEditorUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.esb.project.utils.ESBProjectUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbDiagramEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart.SequencesInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType.*;

/**
 * @generated
 */
public class EsbDiagramEditorUtil {

	/**
	 * @generated
	 */
	public static Map<?, ?> getSaveOptions() {
		HashMap<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		return saveOptions;
	}

	/**
	 * @generated
	 */
	public static boolean openDiagram(Resource diagram) throws PartInitException {
		String path = diagram.getURI().toPlatformString(true);
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
		if (workspaceResource instanceof IFile) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			return null != page.openEditor(new FileEditorInput((IFile) workspaceResource), EsbDiagramEditor.ID);
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static void setCharset(IFile file) {
		if (file == null) {
			return;
		}
		try {
			file.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			EsbDiagramEditorPlugin.getInstance().logError("Unable to set charset for file " + file.getFullPath(), e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated NOT
	 */
	public static String getUniqueFileName(IPath containerFullPath, String fileName, String extension) {
		if (fileName == null || fileName.trim().length() == 0) {
			fileName = "synapse"; //$NON-NLS-1$
		} else {
			fileName = fileName.replaceAll("\\d+$", "");
		}

		String finalName = fileName + "1";
		int i = 1;

		if (containerFullPath != null) {
			try {
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(containerFullPath.segment(0));

				while (ESBProjectUtils.artifactExists(project, finalName)) {
					finalName = finalName.replaceAll("\\d+$", "");
					i++;
					finalName = finalName.concat(i + "");
				}
			} catch (Exception e) {
				finalName = finalName.concat("_").concat(RandomStringUtils.randomAlphabetic(5)).concat("_" + i);
			}
		}

		return finalName;
	}

	/**
	 * Runs the wizard in a dialog.
	 * 
	 * @generated
	 */
	public static void runWizard(Shell shell, Wizard wizard, String settingsKey) {
		IDialogSettings pluginDialogSettings = EsbDiagramEditorPlugin.getInstance().getDialogSettings();
		IDialogSettings wizardDialogSettings = pluginDialogSettings.getSection(settingsKey);
		if (wizardDialogSettings == null) {
			wizardDialogSettings = pluginDialogSettings.addNewSection(settingsKey);
		}
		wizard.setDialogSettings(wizardDialogSettings);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);
		dialog.open();
	}

	/**
	 * This method should be called within a workspace modify operation since it creates resources.
	 * @generated
	 */
	public static Resource createDiagram(URI diagramURI, URI modelURI, IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		progressMonitor.beginTask(Messages.EsbDiagramEditorUtil_CreateDiagramProgressTask, 3);
		final Resource diagramResource = editingDomain.getResourceSet().createResource(diagramURI);
		final Resource modelResource = editingDomain.getResourceSet().createResource(modelURI);
		final String diagramName = diagramURI.lastSegment();
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,
				Messages.EsbDiagramEditorUtil_CreateDiagramCommandLabel, Collections.EMPTY_LIST) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				EsbDiagram model = createInitialModel();
				attachModelToResource(model, modelResource);

				Diagram diagram = ViewService.createDiagram(model, EsbDiagramEditPart.MODEL_ID,
						EsbDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(diagramName);
					diagram.setElement(model);
				}

				try {
					modelResource.save(org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil
							.getSaveOptions());
					diagramResource.save(org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil
							.getSaveOptions());
				} catch (IOException e) {

					EsbDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1),
					null);
		} catch (ExecutionException e) {
			EsbDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
		setCharset(WorkspaceSynchronizer.getFile(modelResource));
		setCharset(WorkspaceSynchronizer.getFile(diagramResource));
		return diagramResource;
	}

	/**
	 * This method should be called within a workspace modify operation since it creates resources.
	 * @generated NOT
	 */
	public static Resource createResource(TransactionalEditingDomain editingDomain, IProgressMonitor progressMonitor,
			final String type, final String fileName, final Object specificType) {
		progressMonitor.beginTask(Messages.EsbDiagramEditorUtil_CreateDiagramProgressTask, 3);
		final String name = fileName.replaceAll(".xml$", "");
		String prefix = "resources/" + name;
		final Resource diagramResource = editingDomain.getResourceSet().createResource(
				URI.createURI(prefix.concat(".esb_diagram")));
		final Resource modelResource = editingDomain.getResourceSet().createResource(
				URI.createURI(prefix.concat(".esb")));
		editingDomain.getResourceSet().getResources().add(diagramResource);
		editingDomain.getResourceSet().getResources().add(modelResource);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,
				Messages.EsbDiagramEditorUtil_CreateDiagramCommandLabel, Collections.EMPTY_LIST) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				EsbDiagram model = createInitialModel();
				EsbServer esbServer = model.getServer();
				if (ArtifactType.SEQUENCE.getLiteral().equals(type)) {
					Sequences sequences = EsbFactory.eINSTANCE.createSequences();
					sequences.setName(fileName);
					if (specificType instanceof SequencesInfo) {
						sequences.setRecieveSequence(((SequencesInfo) specificType).isRecieveSequence());
						sequences.getAssociatedProxy().add(((SequencesInfo) specificType).getAssociatedProxy());
					}
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(sequences));
					esbServer.setType(ArtifactType.SEQUENCE);
				} else if (ArtifactType.PROXY.getLiteral().equals(type)) {
					ProxyService proxyServices = EsbFactory.eINSTANCE.createProxyService();
					String proxyName = name;
					proxyServices.setName(proxyName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(proxyServices));
					esbServer.setType(ArtifactType.PROXY);
				} else if (ArtifactType.ENDPOINT.getLiteral().equals(type)) {
					EndpointDiagram endpoints = EsbFactory.eINSTANCE.createEndpointDiagram();
					/*					if (specificType != null) {
					 switch ((Integer) specificType) {
					 case 0:
					 endpoints.setChild(EsbFactory.eINSTANCE.createDefaultEndPoint());
					 break;
					 case 1:
					 endpoints.setChild(EsbFactory.eINSTANCE.createAddressEndPoint());
					 break;
					 case 2:
					 endpoints.setChild(EsbFactory.eINSTANCE.createWSDLEndPoint());
					 break;
					 case 3:
					 endpoints.setChild(EsbFactory.eINSTANCE.createLoadBalanceEndPoint());
					 break;
					 case 4:
					 endpoints.setChild(EsbFactory.eINSTANCE.createFailoverEndPoint());
					 break;
					 case 5:
					 endpoints.setChild(EsbFactory.eINSTANCE.createRecipientListEndPoint());
					 break;
					 case 6:
					 endpoints.setChild(EsbFactory.eINSTANCE.createTemplateEndpoint());
					 break;
					 case 7:
					 endpoints.setChild(EsbFactory.eINSTANCE.createHTTPEndpoint());
					 break;
					 default:
					 break;
					 }
					 } else {
					 endpoints.setChild(EsbFactory.eINSTANCE.createDefaultEndPoint());
					 }*/
					endpoints.setName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(endpoints));
					esbServer.setType(ArtifactType.ENDPOINT);
				} else if (ArtifactType.LOCAL_ENTRY.getLiteral().equals(type)) {
					LocalEntry localentry = EsbFactory.eINSTANCE.createLocalEntry();
					localentry.setEntryName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(localentry));
					esbServer.setType(ArtifactType.LOCAL_ENTRY);
				} else if (ArtifactType.TEMPLATE_SEQUENCE.getLiteral().equals(type)) {
					Template template = EsbFactory.eINSTANCE.createTemplate();
					template.setName(fileName);
					Sequences sequences = EsbFactory.eINSTANCE.createSequences();
					template.setChild(sequences);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(template));
					esbServer.setType(ArtifactType.TEMPLATE_SEQUENCE);
				} else if (ArtifactType.TEMPLATE_ENDPOINT_ADDRESS.getLiteral().equals(type)) {
					Template template = EsbFactory.eINSTANCE.createTemplate();
					template.setName(fileName);
					EndpointDiagram endpoint = EsbFactory.eINSTANCE.createEndpointDiagram();
					endpoint.setChild(EsbFactory.eINSTANCE.createAddressEndPoint());
					template.setChild(endpoint);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(template));
					esbServer.setType(ArtifactType.TEMPLATE_ENDPOINT_ADDRESS);
				} else if (ArtifactType.TEMPLATE_ENDPOINT_WSDL.getLiteral().equals(type)) {
					Template template = EsbFactory.eINSTANCE.createTemplate();
					template.setName(fileName);
					EndpointDiagram endpoint = EsbFactory.eINSTANCE.createEndpointDiagram();
					endpoint.setChild(EsbFactory.eINSTANCE.createWSDLEndPoint());
					template.setChild(endpoint);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(template));
					esbServer.setType(ArtifactType.TEMPLATE_ENDPOINT_WSDL);
				} else if (ArtifactType.TEMPLATE_ENDPOINT_DEFAULT.getLiteral().equals(type)) {
					Template template = EsbFactory.eINSTANCE.createTemplate();
					template.setName(fileName);
					EndpointDiagram endpoint = EsbFactory.eINSTANCE.createEndpointDiagram();
					endpoint.setChild(EsbFactory.eINSTANCE.createDefaultEndPoint());
					template.setChild(endpoint);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(template));
					esbServer.setType(ArtifactType.TEMPLATE_ENDPOINT_DEFAULT);
				} else if (ArtifactType.TEMPLATE_ENDPOINT_HTTP.getLiteral().equals(type)) {
					Template template = EsbFactory.eINSTANCE.createTemplate();
					template.setName(fileName);
					EndpointDiagram endpoint = EsbFactory.eINSTANCE.createEndpointDiagram();
					endpoint.setChild(EsbFactory.eINSTANCE.createHTTPEndpoint());
					template.setChild(endpoint);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(template));
					esbServer.setType(ArtifactType.TEMPLATE_ENDPOINT_HTTP);
				} else if (ArtifactType.TASK.getLiteral().equals(type)) {
					Task task = EsbFactory.eINSTANCE.createTask();
					task.setTaskName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(task));
					esbServer.setType(ArtifactType.TASK);
				} else if (ArtifactType.API.getLiteral().equals(type)) {
					SynapseAPI api = EsbFactory.eINSTANCE.createSynapseAPI();
					api.setApiName(fileName);
					APIResource apiResource = EsbFactory.eINSTANCE.createAPIResource();
					api.getResources().add(apiResource);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(api));
					esbServer.setType(ArtifactType.API);
				} else if (ArtifactType.MAIN_SEQUENCE.getLiteral().equals(type)) {
					ProxyService proxyServices = EsbFactory.eINSTANCE.createProxyService();
					proxyServices.setMainSequence(true);
					proxyServices.setName("main");
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(proxyServices));
					esbServer.setType(ArtifactType.MAIN_SEQUENCE);
				} else if (ArtifactType.COMPLEX_ENDPOINT.getLiteral().equals(type)) {
					ComplexEndpoints complexEndpoints = EsbFactory.eINSTANCE.createComplexEndpoints();
					complexEndpoints.setName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(complexEndpoints));
					esbServer.setType(ArtifactType.COMPLEX_ENDPOINT);
				} else if (ArtifactType.MESSAGE_STORE.getLiteral().equals(type)) {
					MessageStore messageStore = EsbFactory.eINSTANCE.createMessageStore();
					messageStore.setStoreName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(messageStore));
					esbServer.setType(ArtifactType.MESSAGE_STORE);
				} else if (ArtifactType.MESSAGE_PROCESSOR.getLiteral().equals(type)) {
					MessageProcessor messageProcessor = EsbFactory.eINSTANCE.createMessageProcessor();
					messageProcessor.setProcessorName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(messageProcessor));
					esbServer.setType(ArtifactType.MESSAGE_PROCESSOR);
				} else if (ArtifactType.INBOUND_ENDPOINT.getLiteral().equals(type)) {
					InboundEndpoint inboundEndpoint = EsbFactory.eINSTANCE.createInboundEndpoint();
					inboundEndpoint.setName(fileName);
					EStructuralFeature target = esbServer.eClass().getEStructuralFeature("children");
					esbServer.eSet(target, Arrays.asList(inboundEndpoint));
					esbServer.setType(ArtifactType.INBOUND_ENDPOINT);
				}

				attachModelToResource(model, modelResource);

				Diagram diagram = ViewService.createDiagram(model, EsbDiagramEditPart.MODEL_ID,
						EsbDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(name);
					diagram.setElement(model);
				}

				try {
					modelResource.save(org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil
							.getSaveOptions());
					diagramResource.save(org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorUtil
							.getSaveOptions());
				} catch (IOException e) {

					EsbDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1),
					null);
		} catch (ExecutionException e) {
			EsbDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
		setCharset(WorkspaceSynchronizer.getFile(modelResource));
		setCharset(WorkspaceSynchronizer.getFile(diagramResource));
		return diagramResource;
	}

	/**
	 * Create a new instance of domain element associated with canvas.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static EsbDiagram createInitialModel() {
		return EsbFactory.eINSTANCE.createEsbDiagram();
	}

	/**
	 * Store model element in the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static void attachModelToResource(EsbDiagram model, Resource resource) {
		resource.getContents().add(model);
	}

	/**
	 * @generated
	 */
	public static void selectElementsInDiagram(IDiagramWorkbenchPart diagramPart, List<EditPart> editParts) {
		diagramPart.getDiagramGraphicalViewer().deselectAll();

		EditPart firstPrimary = null;
		for (EditPart nextPart : editParts) {
			diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
			if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
				firstPrimary = nextPart;
			}
		}

		if (!editParts.isEmpty()) {
			diagramPart.getDiagramGraphicalViewer().reveal(
					firstPrimary != null ? firstPrimary : (EditPart) editParts.get(0));
		}
	}

	/**
	 * @generated
	 */
	private static int findElementsInDiagramByID(DiagramEditPart diagramPart, EObject element,
			List<EditPart> editPartCollector) {
		IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer) diagramPart.getViewer();
		final int intialNumOfEditParts = editPartCollector.size();

		if (element instanceof View) { // support notation element lookup
			EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(element);
			if (editPart != null) {
				editPartCollector.add(editPart);
				return 1;
			}
		}

		String elementID = EMFCoreUtil.getProxyID(element);
		@SuppressWarnings("unchecked")
		List<EditPart> associatedParts = viewer.findEditPartsForElement(elementID, IGraphicalEditPart.class);
		// perform the possible hierarchy disjoint -> take the top-most parts only
		for (EditPart nextPart : associatedParts) {
			EditPart parentPart = nextPart.getParent();
			while (parentPart != null && !associatedParts.contains(parentPart)) {
				parentPart = parentPart.getParent();
			}
			if (parentPart == null) {
				editPartCollector.add(nextPart);
			}
		}

		if (intialNumOfEditParts == editPartCollector.size()) {
			if (!associatedParts.isEmpty()) {
				editPartCollector.add(associatedParts.get(0));
			} else {
				if (element.eContainer() != null) {
					return findElementsInDiagramByID(diagramPart, element.eContainer(), editPartCollector);
				}
			}
		}
		return editPartCollector.size() - intialNumOfEditParts;
	}

	/**
	 * @generated
	 */
	public static View findView(DiagramEditPart diagramEditPart, EObject targetElement,
			LazyElement2ViewMap lazyElement2ViewMap) {
		boolean hasStructuralURI = false;
		if (targetElement.eResource() instanceof XMLResource) {
			hasStructuralURI = ((XMLResource) targetElement.eResource()).getID(targetElement) == null;
		}

		View view = null;
		LinkedList<EditPart> editPartHolder = new LinkedList<EditPart>();
		if (hasStructuralURI && !lazyElement2ViewMap.getElement2ViewMap().isEmpty()) {
			view = lazyElement2ViewMap.getElement2ViewMap().get(targetElement);
		} else if (findElementsInDiagramByID(diagramEditPart, targetElement, editPartHolder) > 0) {
			EditPart editPart = editPartHolder.get(0);
			view = editPart.getModel() instanceof View ? (View) editPart.getModel() : null;
		}

		return (view == null) ? diagramEditPart.getDiagramView() : view;
	}

	/**
	 * @generated
	 */
	public static class LazyElement2ViewMap {
		/**
		 * @generated
		 */
		private Map<EObject, View> element2ViewMap;

		/**
		 * @generated
		 */
		private View scope;

		/**
		 * @generated
		 */
		private Set<? extends EObject> elementSet;

		/**
		 * @generated
		 */
		public LazyElement2ViewMap(View scope, Set<? extends EObject> elements) {
			this.scope = scope;
			this.elementSet = elements;
		}

		/**
		 * @generated
		 */
		public final Map<EObject, View> getElement2ViewMap() {
			if (element2ViewMap == null) {
				element2ViewMap = new HashMap<EObject, View>();
				// map possible notation elements to itself as these can't be found by view.getElement()
				for (EObject element : elementSet) {
					if (element instanceof View) {
						View view = (View) element;
						if (view.getDiagram() == scope.getDiagram()) {
							element2ViewMap.put(element, view); // take only those that part of our diagram
						}
					}
				}

				buildElement2ViewMap(scope, element2ViewMap, elementSet);
			}
			return element2ViewMap;
		}

		/**
		 * @generated
		 */
		private static boolean buildElement2ViewMap(View parentView, Map<EObject, View> element2ViewMap,
				Set<? extends EObject> elements) {
			if (elements.size() == element2ViewMap.size()) {
				return true;
			}

			if (parentView.isSetElement() && !element2ViewMap.containsKey(parentView.getElement())
					&& elements.contains(parentView.getElement())) {
				element2ViewMap.put(parentView.getElement(), parentView);
				if (elements.size() == element2ViewMap.size()) {
					return true;
				}
			}
			boolean complete = false;
			for (Iterator<?> it = parentView.getChildren().iterator(); it.hasNext() && !complete;) {
				complete = buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
			}
			for (Iterator<?> it = parentView.getSourceEdges().iterator(); it.hasNext() && !complete;) {
				complete = buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
			}
			for (Iterator<?> it = parentView.getTargetEdges().iterator(); it.hasNext() && !complete;) {
				complete = buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
			}
			return complete;
		}
	} //LazyElement2ViewMap	

}
