package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure;

import java.io.File;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LogLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EditorUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddCaseBranchDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui.AddTargetBranchDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;

public class LoadParametersFromSchemaAction extends ConfigureEsbNodeAction {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public LoadParametersFromSchemaAction(IWorkbenchPart part) {
        super(part);
        setId("load-parameters-from-schema");
        setText("Load Parameters from Schema");
        setToolTipText("Load Parameters from Schema of the connector");
        ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
        setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));
    }

    protected void doRun(IProgressMonitor progressMonitor) {
        EditPart selectedEP = getSelectedEditPart();
        Assert.isNotNull(selectedEP, "Empty selection.");

        EObject selectedObj = ((View) selectedEP.getModel()).getElement();
        Assert.isTrue(selectedObj instanceof CloudConnectorOperation, "Invalid selection.");

        CloudConnectorOperation cloudConnector = (CloudConnectorOperation) selectedObj;

        IProject activeProject = EditorUtils.getActiveProject();

        String connectorPath = CloudConnectorDirectoryTraverser.getInstance()
                .getConnectorDirectoryPathFromConnectorName(
                        activeProject.getWorkspace().getRoot().getLocation().toOSString(),
                        cloudConnector.getCloudConnectorName());
        CloudConnectorDirectoryTraverser cloudConnectorDirectoryTraverser = CloudConnectorDirectoryTraverser
                .getInstance(connectorPath);

        Map<String, String> parameterDefaultValuesMap = cloudConnectorDirectoryTraverser
                .getInputDefaultParameterValuesMap(cloudConnector.getOperationName());
        if (parameterDefaultValuesMap == null) {
            log.warn("Default values for connector operation not found");
            MessageDialog.openWarning(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
                    "Connector default values loading error",
                    "Default values for connector operation parameters could not be found");
            return;
        }

        EList<CallTemplateParameter> cloudConnectorParameters = cloudConnector.getConnectorParameters();

        CompoundCommand resultCommand = new CompoundCommand();
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(cloudConnector);

        // set editing type to name-space editor
        SetCommand setEditingTypeCmd = new SetCommand(editingDomain, cloudConnector,
                EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__PARAMETER_EDITOR_TYPE,
                CloudConnectorOperationParamEditorType.NAMESPACED_PROPERTY_EDITOR);
        resultCommand.append(setEditingTypeCmd);

        for (CallTemplateParameter parameter : cloudConnectorParameters) {
            String paramValue = parameterDefaultValuesMap.get(parameter.getParameterName());
            if (!StringUtils.isEmpty(paramValue)) {
                NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
                namespaceProperty.setSupportsDynamicXPaths(true);

                if (paramValue.startsWith("\"") && paramValue.endsWith("\"")) {
                    // removing leading and trailing double quotes
                    paramValue = paramValue.substring(1, paramValue.length() - 1);
                }
                paramValue = "{" + paramValue + "}";
                namespaceProperty.setPropertyValue(paramValue);
                namespaceProperty.setDynamic(true);
                SetCommand setParamValueCmd = new SetCommand(editingDomain, parameter,
                        EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION, namespaceProperty);
                resultCommand.append(setParamValueCmd);
            }
        }

        if (resultCommand.canExecute()) {
            editingDomain.getCommandStack().execute(resultCommand);
        }
    }

}
