package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.suspendpoint;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.Breakpoint;
import org.eclipse.debug.core.model.IBreakpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.impl.ESBDebugPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants;

/**
 * This class represents the Suspend Point type for ESB Mediation Debugger and
 * extended from {@link Breakpoint}.Suspend Points are saved in {@link BreakpointManager}.
 */
public class ESBSuspendPoint extends Breakpoint {

    private String toolTipMessage;
    private ESBDebugPoint suspendedPoint;

    public ESBSuspendPoint(final IResource resource, final int lineNumber, final ESBDebugPoint suspendPoint)
            throws DebugException {
        this(resource, lineNumber, suspendPoint, null);
    }

    public ESBSuspendPoint(final IResource resource, final int lineNumber, final ESBDebugPoint suspendPoint,
            final String toolTipMessage) throws DebugException {
        this.setSuspendedPoint(suspendPoint);
        this.toolTipMessage = toolTipMessage;

        IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
            @Override
            public void run(IProgressMonitor monitor) throws CoreException {
                IMarker marker = resource.createMarker(ESBDebuggerConstants.ESB_BREAKPOINT_MARKER_ID);
                setMarker(marker);
                setEnabled(true);
                ensureMarker().setAttribute(IBreakpoint.PERSISTED, false);
                ensureMarker().setAttribute(IBreakpoint.ENABLED, true);
                ensureMarker().setAttribute(IBreakpoint.ID, getModelIdentifier());
            }
        };
        run(getMarkerRule(resource), runnable);
    }

    @Override
    public String getModelIdentifier() {
        return ESBDebuggerConstants.SUSPEND_POINT_MODEL_ID;
    }

    public String getToolTipMessage() {
        return toolTipMessage;
    }

    public void setToolTipMessage(String toolTipMessage) {
        this.toolTipMessage = toolTipMessage;
    }

    public ESBDebugPoint getSuspendedPoint() {
        return suspendedPoint;
    }

    public void setSuspendedPoint(ESBDebugPoint suspendedPoint) {
        this.suspendedPoint = suspendedPoint;
    }

}
