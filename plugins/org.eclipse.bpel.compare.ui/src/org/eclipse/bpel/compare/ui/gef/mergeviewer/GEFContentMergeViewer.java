package org.eclipse.bpel.compare.ui.gef.mergeviewer;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.ExtensionmodelFactory;
import org.eclipse.bpel.compare.ui.annotation.AnnotationsStore;
import org.eclipse.bpel.compare.ui.gef.bpel.BPELCompareEditPartFactory;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.ResourceNode;
import org.eclipse.compare.contentmergeviewer.ContentMergeViewer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.ui.AbstractCompareAction;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * ContentMergeViewer to merge EMF models using GEF panes.
 *
 */
public abstract class GEFContentMergeViewer extends ContentMergeViewer {
	
	/** Name of the bundle resources property file. */
	public static final String BUNDLE_NAME = "org.eclipse.bpel.compare.ui.gef.mergeviewer.GEFContentMergeViewerResources"; //$NON-NLS-1$
	
	/**
	 * these viewers should be initialized by subclass in {@link #createControls(Composite) 
	 */
	protected EditPartViewer viewerLeft;
	protected EditPartViewer viewerRight;
	protected EditPartViewer viewerAncestor;
	protected Text txtMessage;
	private final CompareConfiguration configuration;
	
	
	protected GEFContentMergeViewer(Composite parent, CompareConfiguration cc) {
		super(SWT.NONE, null, cc);
		configuration = cc;
		buildControl(parent);
	}
	

	@Override
	protected void copy(boolean leftToRight) {
		// TODO Auto-generated method stub
	}

	@Override
	protected byte[] getContents(boolean left) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void handleResizeAncestor(int x, int y, int width, int height) {
		if (viewerAncestor != null) {
			if (width > 0) {
				viewerAncestor.getControl().setVisible(true);
				viewerAncestor.getControl().setBounds(x, y, width, height);
			} else {
				viewerAncestor.getControl().setVisible(false);
			}
		} 
	}

	@Override
	protected void handleResizeLeftRight(int x, int y, int leftWidth,
			int centerWidth, int rightWidth, int height) {
		final int txtMessegeHeight = 100;
		viewerLeft.getControl().setBounds(x, y, leftWidth, height-txtMessegeHeight);
		viewerRight.getControl().setBounds(x + leftWidth + centerWidth, y, rightWidth, height-txtMessegeHeight);
		if (viewerLeft.getRootEditPart() instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart)viewerLeft
					.getRootEditPart();
			rootEditPart.getZoomManager().setZoomAnimationStyle(ZoomManager.ANIMATE_NEVER);
			rootEditPart.getZoomManager().setZoom(0.7);
		}
		if (viewerRight.getRootEditPart() instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart)viewerRight
					.getRootEditPart();
			rootEditPart.getZoomManager().setZoomAnimationStyle(ZoomManager.ANIMATE_NEVER);
			rootEditPart.getZoomManager().setZoom(0.7);
		}
		txtMessage.setBounds(x, y + height - txtMessegeHeight + centerWidth,
				leftWidth + centerWidth + rightWidth, txtMessegeHeight - centerWidth);
	}

	@SuppressWarnings("restriction")
	@Override
	protected void updateContent(Object ancestor, Object left, Object right) {
		Resource resourceLeft = null;
		Resource resourceRight = null;
		Resource resourceAnc = null;
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		
		String nameRight;
		String nameLeft;
		String nameAncestor;
		
		if(left instanceof ResourceNode) {
			nameLeft = URI.createPlatformResourceURI(
					((ResourceNode)left).getResource().getFullPath().toString(),
					true).toString();
		} else {
			nameLeft = ((ITypedElement)left).getName();
		}
		if(right instanceof ResourceNode) {
			nameRight = URI.createPlatformResourceURI(
					((ResourceNode)right).getResource().getFullPath().toString(),
					true).toString();
		} else {
			nameRight = ((ITypedElement)right).getName();
		}
		if(ancestor instanceof ResourceNode) {
			nameAncestor = URI.createPlatformResourceURI(
					((ResourceNode)right).getResource().getFullPath().toString(),
					true).toString();
		} else {
			nameAncestor = ((ITypedElement)right).getName();
		}

		try {
			resourceLeft = ModelUtils.load(((IStreamContentAccessor)left)
					.getContents(), nameLeft, resourceSet).eResource();			
			loadAssociatedBPELEX(resourceSet, nameLeft);	

			
			resourceRight = ModelUtils.load(((IStreamContentAccessor)right)
					.getContents(), nameRight, resourceSet).eResource();
			loadAssociatedBPELEX(resourceSet, nameRight);	
			
			if (ancestor != null) {
				resourceAnc = ModelUtils.load(((IStreamContentAccessor)ancestor)
						.getContents(), nameAncestor, resourceSet).eResource();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EObject modelLeft = (EObject) resourceLeft.getContents().get(0);
		EObject modelRight = (EObject) resourceRight.getContents().get(0);
		EObject modelAncestor = null;
		if (resourceAnc != null) {
			modelAncestor = (EObject) resourceAnc.getContents().get(0);
		}
		
		AnnotationsStore.getInstance().annotate(getCompareConfiguration(), modelLeft, modelRight);
		updateContent(modelAncestor, modelLeft, modelRight);
		// TODO: attach listeners
		
	}


	private void loadAssociatedBPELEX(ResourceSetImpl resourceSet,
			String bpelexName) throws IOException {
		ExtensionMap extensionMap = null;
		Resource extensionsResource = null;
		org.eclipse.core.runtime.IPath extensionsPath = (new org.eclipse.core.runtime.Path(bpelexName)).removeFileExtension().addFileExtension(IBPELUIConstants.EXTENSION_MODEL_EXTENSIONS);
		URI extensionsUri = URI.createURI(extensionsPath.toString());
		ModelUtils.load(extensionsUri, resourceSet);
		//IFile extensionsFile = ResourcesPlugin.getWorkspace().getRoot().getFile(extensionsPath);
		try {
			//extensionsResource = resourceSet.getResource(extensionsUri, extensionsFile.exists());
			extensionsResource = ModelUtils.load(extensionsUri, resourceSet).eResource();
			if (extensionsResource != null) {
				extensionMap = ExtensionmodelFactory.eINSTANCE.findExtensionMap(
						IBPELUIConstants.MODEL_EXTENSIONS_NAMESPACE, extensionsResource.getContents());
			}
		} catch (Exception e) {
			BPELUIPlugin.log(e);
		}
		if (extensionMap != null) extensionMap.initializeAdapter();


		if (extensionMap == null) {
			extensionMap = ExtensionmodelFactory.eINSTANCE.createExtensionMap(IBPELUIConstants.MODEL_EXTENSIONS_NAMESPACE);
			if (extensionsResource == null) {
				extensionsResource = resourceSet.createResource(extensionsUri);
			}
			extensionsResource.getContents().clear();
			extensionsResource.getContents().add(extensionMap);
		}
	}
	
	@Override
	protected void createControls(Composite composite) {
		initializeViewers(composite);
		txtMessage = new Text(composite, SWT.MULTI | SWT.READ_ONLY);
	}
	

	public void selectionChanged(EditPartViewer viewer) {
		if (viewer.equals(viewerLeft)) {
			selectPairEditPart(true);
		} else if (viewer.equals(viewerRight)) {
			selectPairEditPart(false);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	protected void createToolItems(ToolBarManager tbm) {
		/*// COPY DIFF LEFT TO RIGHT
		if (getCompareConfiguration().isRightEditable()) {
			copyDiffLeftToRight = new AbstractCompareAction(ResourceBundle.getBundle(BUNDLE_NAME),
					"action.CopyDiffLeftToRight.") { //$NON-NLS-1$
				@Override
				public void run() {
//					copyDiffLeftToRight();
				}
			};
			final ActionContributionItem copyLeftToRightContribution = new ActionContributionItem(
					copyDiffLeftToRight);
			copyLeftToRightContribution.setVisible(true);
			tbm.appendToGroup("merge", copyLeftToRightContribution); //$NON-NLS-1$
		}
		// COPY DIFF RIGHT TO LEFT
		if (getCompareConfiguration().isLeftEditable()) {
			copyDiffRightToLeft = new AbstractCompareAction(ResourceBundle.getBundle(BUNDLE_NAME),
					"action.CopyDiffRightToLeft.") { //$NON-NLS-1$
				@Override
				public void run() {
//					copyDiffRightToLeft();
				}
			};
			final ActionContributionItem copyRightToLeftContribution = new ActionContributionItem(
					copyDiffRightToLeft);
			copyRightToLeftContribution.setVisible(true);
			tbm.appendToGroup("merge", copyRightToLeftContribution); //$NON-NLS-1$
		}*/
		// NEXT DIFF
		final Action nextDiff = new AbstractCompareAction(ResourceBundle.getBundle(BUNDLE_NAME),
				"action.NextDiff.") { //$NON-NLS-1$
			@Override
			public void run() {
				navigate(true);
			}
		};
		final ActionContributionItem nextDiffContribution = new ActionContributionItem(nextDiff);
		nextDiffContribution.setVisible(true);
		tbm.appendToGroup("navigation", nextDiffContribution); //$NON-NLS-1$
		// PREVIOUS DIFF
		final Action previousDiff = new AbstractCompareAction(ResourceBundle.getBundle(BUNDLE_NAME),
				"action.PrevDiff.") { //$NON-NLS-1$
			@Override
			public void run() {
				navigate(false);
			}
		};
		final ActionContributionItem previousDiffContribution = new ActionContributionItem(previousDiff);
		previousDiffContribution.setVisible(true);
		tbm.appendToGroup("navigation", previousDiffContribution); //$NON-NLS-1$
	}
	
	private void navigate(boolean next) {
		EObject selectedModel = getSelectedModel(true);
		DiffElement selectedAnnotation = AnnotationsStore.getInstance().getAnnotation(selectedModel);
		List<DiffElement> annotations = AnnotationsStore.getInstance().annotations.get(getCompareConfiguration());
		int curIndex = annotations.indexOf(selectedAnnotation);
		if (next) {
			// go to next
			if (annotations.size() > curIndex + 1) {
				DiffElement annotation = annotations.get(curIndex + 1);
				navigateToDiff(annotation);
			}
		} else {
			// go to previous
			int prevIndex = curIndex - 1;
			if (prevIndex >= 0 && prevIndex < annotations.size()) {
				DiffElement annotation = annotations.get(prevIndex);
				navigateToDiff(annotation);
			}
		}
			
	}
	
	private void navigateToDiff(DiffElement annotation) {
		if (annotation != null) {
			if (annotation instanceof ModelElementChangeRightTarget) {
				EObject leftObject = ((ModelElementChangeRightTarget) annotation).getLeftParent();
				while (!(leftObject instanceof Activity)) {
					leftObject = leftObject.eContainer();
				}
				Activity leftParent = (Activity) leftObject;
//				viewerLeft.select(BPELCompareEditPartFactory.getEditPart(leftParent));
				EObject rightObject = ((ModelElementChangeRightTarget) annotation).getRightElement();
				while (!(rightObject instanceof Activity)) {
					rightObject = rightObject.eContainer();
				}
				Activity rightElement = (Activity) rightObject;
				viewerRight.select(BPELCompareEditPartFactory.getEditPart(rightElement));
				String leftParentName = leftParent.getName() != null ?
						leftParent.getName() : leftParent.toString();
				txtMessage.setText(rightElement.getName() + " has been added into " +
						leftParentName);
			} else if (annotation instanceof ModelElementChangeLeftTarget) {
				EObject leftObject = ((ModelElementChangeLeftTarget) annotation).getLeftElement();
				while (!(leftObject instanceof Activity)) {
					leftObject = leftObject.eContainer();
				}
				Activity leftElement = (Activity) leftObject;
				viewerLeft.select(BPELCompareEditPartFactory.getEditPart(leftElement));
				EObject rightObject = ((ModelElementChangeLeftTarget) annotation).getRightParent();
				while (!(rightObject instanceof Activity)) {
					rightObject = rightObject.eContainer();
				}
				Activity rightParent = (Activity) rightObject;
//				viewerRight.select(BPELCompareEditPartFactory.getEditPart(rightParent));
				String rightParentName = rightParent.getName() != null ?
						rightParent.getName() : rightParent.toString();
				txtMessage.setText(leftElement.getName() + " has been removed from " +
						rightParentName);
			}
//				EObject leftObject = ((RemoveModelElement) annotation).getLeftElement();
//				while (!(leftObject instanceof Activity)) {
//					leftObject = leftObject.eContainer();
//				}
//				Activity leftElement = (Activity) leftObject;
//				viewerLeft.select(BPELCompareEditPartFactory.getEditPart(leftElement));
//				EObject rightObject = ((RemoveModelElement) annotation).getRightParent();
//				while (!(rightObject instanceof Activity)) {
//					rightObject = rightObject.eContainer();
//				}
//				Activity rightParent = (Activity) rightObject;
//				viewerRight.select(BPELCompareEditPartFactory.getEditPart(rightParent));
//				String rightParentName = rightParent.getName() != null ?
//						rightParent.getName() : rightParent.toString();
//				txtMessage.setText(leftElement.getName() + " has been removed from " +
//						rightParentName);
			 else if (annotation instanceof MoveModelElement) {
				EObject leftObject = ((MoveModelElement) annotation).getLeftElement();
				while (!(leftObject instanceof Activity)) {
					leftObject = leftObject.eContainer();
				}
				Activity leftElement = (Activity) leftObject;
				
				EObject rightObject = ((MoveModelElement) annotation).getRightElement();
				while (!(rightObject instanceof Activity)) {
					rightObject = rightObject.eContainer();
				}
				Activity rightElement = (Activity) leftObject;
				
//				if (left) {
					viewerRight.select(BPELCompareEditPartFactory.getEditPart(
							rightElement));
//				} else {
					viewerLeft.select(BPELCompareEditPartFactory.getEditPart(
							leftElement));
//				}
				Activity leftTarget = (Activity) leftElement.eContainer();
				Activity rightTarget = (Activity) rightElement.eContainer();
				String leftTargetName = leftTarget.getName() == null ?
						leftTarget.toString() : leftTarget.getName();
				String rightTargetName = rightTarget.getName() != null ?
						rightTarget.getName() : rightTarget.toString();
				txtMessage.setText(rightElement.getName() + " has been moved from " +
						leftTargetName + " to " + rightTargetName);
			} else if (annotation instanceof UpdateAttribute) {
//				if (left) {
					viewerRight.select(BPELCompareEditPartFactory.getEditPart(
							((UpdateAttribute) annotation).getRightElement()));
//				} else {
					viewerLeft.select(BPELCompareEditPartFactory.getEditPart(
							((UpdateAttribute) annotation).getLeftElement()));
//				}
				txtMessage.setText(annotation.toString());
			}
		} else {
			txtMessage.setText("");
//			if (left) {
				viewerRight.deselectAll();
//			} else {
				viewerLeft.deselectAll();
//			}
		}
	}
	
	private EObject getSelectedModel(boolean left) {
		List editParts;
		if (left) {
			editParts = viewerLeft.getSelectedEditParts();
		} else {
			editParts = viewerRight.getSelectedEditParts();
		}
		if (editParts.size() == 0) {
			return null;
		}
		EditPart editPart = (EditPart) editParts.get(0);
		return (EObject) editPart.getModel();
	}

	private void selectPairEditPart(boolean left) {
		DiffElement annotation = AnnotationsStore.getInstance()
				.getAnnotation(getSelectedModel(left));
		navigateToDiff(annotation);
	}

	protected abstract void initializeViewers(Composite composite);

	protected abstract void updateContent(EObject modelAncestor, EObject modelleft, EObject right);
	
}
