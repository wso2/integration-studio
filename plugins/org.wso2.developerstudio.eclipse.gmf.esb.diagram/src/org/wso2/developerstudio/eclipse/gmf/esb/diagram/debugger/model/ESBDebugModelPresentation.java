package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;

/**
 * This class extends from {@link IDebugModelPresentation} is responsible for
 * providing labels, images and editors associated with debug elements.
 *
 */
public class ESBDebugModelPresentation implements IDebugModelPresentation {

    public static final String ID = ESBDebuggerConstants.ESB_DEBUG_MODEL_PRESENTATION_ID;

    @Override
    public void addListener(ILabelProviderListener listener) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
    }

    @Override
    public IEditorInput getEditorInput(Object element) {
        if (element instanceof IFile) {
            return new FileEditorInput((IFile) element);
        }
        return null;
    }

    @Override
    public String getEditorId(IEditorInput input, Object element) {
        if (element instanceof IFile) {
            return PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(((IFile) element).getName()).getId();
        }
        return null;
    }

    @Override
    public void setAttribute(String attribute, Object value) {
    }

    @Override
    public Image getImage(Object element) {
        return null;
    }

    @Override
    public String getText(Object element) {
        return null;
    }

    @Override
    public void computeDetail(IValue value, IValueDetailListener listener) {
    }

}
