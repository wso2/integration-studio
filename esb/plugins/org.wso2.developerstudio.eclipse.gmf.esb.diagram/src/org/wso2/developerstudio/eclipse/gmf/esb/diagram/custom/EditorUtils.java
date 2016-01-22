/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.synapse.Mediator;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyService;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector.CloudConnectorDirectoryTraverser;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceFaultInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceOutSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ComplexEndpointsEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ComplexEndpointsOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbDiagramEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EsbLinkEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.InboundEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment10EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment11EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment4EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment7EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment8EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartment9EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.MediatorFlowMediatorFlowCompartmentEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyFaultInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyInputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyOutSequenceOutputConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.Sequences2EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequencesEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchCaseParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchDefaultParentContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.CustomPaletteViewerKeyHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbEditorInput;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbMultiPageEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbPaletteFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.CloudConnectorOperationImpl;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class EditorUtils {
	
	public static final String DIAGRAM_FILE_EXTENSION = ".esb_diagram";
	public static final String DOMAIN_FILE_EXTENSION = ".esb";
	public static final String SYNAPSE_CONFIG_DIR = "src/main/synapse-config";
	public static final String SYNAPSE_RESOURCE_DIR = "src/main/graphical-synapse-config";
	public static final String SEQUENCE_RESOURCE_DIR = "src/main/graphical-synapse-config/sequences";
	public static final String PROXY_RESOURCE_DIR = "src/main/graphical-synapse-config/proxy-services";
	public static final String ENDPOINT_RESOURCE_DIR = "src/main/graphical-synapse-config/endpoints";
	public static final String LOCAL_ENTRY_RESOURCE_DIR = "src/main/graphical-synapse-config/local-entries";
	public static final String TEMPLATE_RESOURCE_DIR = "src/main/graphical-synapse-config/templates";
	public static final String TASK_RESOURCE_DIR = "src/main/graphical-synapse-config/tasks";
	public static final String API_RESOURCE_DIR = "src/main/graphical-synapse-config/api";
	public static final String COMPLEX_ENDPOINT_RESOURCE_DIR = "src/main/graphical-synapse-config/complex_endpoints";
	private static final int NUMBER_OF_SEGMENTS_IN_PATH_AFTER_ESBCONFIG_PROJECT = 5;

	public static AbstractInputConnectorEditPart getInputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AbstractInputConnectorEditPart){
				return (AbstractInputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static AbstractOutputConnectorEditPart getOutputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AbstractOutputConnectorEditPart){
				return (AbstractOutputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	/**
	 * Look up InputConnector by EditPart and type
	 * @param <T>
	 * @param parent
	 * @param type
	 * @return
	 */
	public static <T extends AbstractInputConnectorEditPart> T getInputConnector(
			ShapeNodeEditPart parent, Class<T> type) {
		for (int i = 0; i < parent.getChildren().size(); ++i) {
			if (type.isInstance(parent.getChildren().get(i))) {
				return type.cast(parent.getChildren().get(i));
			}
		}
		return null;
	}
	
	/**
	 * Look up OutputConnector by EditPart and type
	 * @param <T>
	 * @param parent
	 * @param type
	 * @return
	 */
	public static <T extends AbstractOutputConnectorEditPart> T getOutputConnector(
			ShapeNodeEditPart parent, Class<T> type) {
		for (int i = 0; i < parent.getChildren().size(); ++i) {
			if (type.isInstance(parent.getChildren().get(i))) {
				return type.cast(parent.getChildren().get(i));
			}
		}
		return null;
	}
	
    /**
     * This method returns the InputConnector of the given mediator.
     * 
     * @param mediator
     * @return
     */
    public static InputConnector getInputConnectorFromMediator(org.wso2.developerstudio.eclipse.gmf.esb.Mediator mediator) {

        if (mediator instanceof AggregateMediator) {
            return ((AggregateMediator) mediator).getInputConnector();
        } else if (mediator instanceof CacheMediator) {
            return ((CacheMediator) mediator).getInputConnector();
        } else if (mediator instanceof CalloutMediator) {
            return ((CalloutMediator) mediator).getInputConnector();
        } else if (mediator instanceof CallTemplateMediator) {
            return ((CallTemplateMediator) mediator).getInputConnector();
        } else if (mediator instanceof ClassMediator) {
            return ((ClassMediator) mediator).getInputConnector();
        } else if (mediator instanceof CloneMediator) {
            return ((CloneMediator) mediator).getInputConnector();
        } else if (mediator instanceof CommandMediator) {
            return ((CommandMediator) mediator).getInputConnector();
        } else if (mediator instanceof DBLookupMediator) {
            return ((DBLookupMediator) mediator).getInputConnector();
        } else if (mediator instanceof DBReportMediator) {
            return ((DBReportMediator) mediator).getInputConnector();
        } else if (mediator instanceof DropMediator) {
            return ((DropMediator) mediator).getInputConnector();
        } else if (mediator instanceof EnqueueMediator) {
            return ((EnqueueMediator) mediator).getInputConnector();
        } else if (mediator instanceof EnrichMediator) {
            return ((EnrichMediator) mediator).getInputConnector();
        } else if (mediator instanceof EntitlementMediator) {
            return ((EntitlementMediator) mediator).getInputConnector();
        } else if (mediator instanceof EventMediator) {
            return ((EventMediator) mediator).getInputConnector();
        } else if (mediator instanceof FaultMediator) {
            return ((FaultMediator) mediator).getInputConnector();
        } else if (mediator instanceof FilterMediator) {
            return ((FilterMediator) mediator).getInputConnector();
        } else if (mediator instanceof HeaderMediator) {
            return ((HeaderMediator) mediator).getInputConnector();
        } else if (mediator instanceof IterateMediator) {
            return ((IterateMediator) mediator).getInputConnector();
        } else if (mediator instanceof LogMediator) {
            return ((LogMediator) mediator).getInputConnector();
        } else if (mediator instanceof OAuthMediator) {
            return ((OAuthMediator) mediator).getInputConnector();
        } else if (mediator instanceof PayloadFactoryMediator) {
            return ((PayloadFactoryMediator) mediator).getInputConnector();
        } else if (mediator instanceof PropertyMediator) {
            return ((PropertyMediator) mediator).getInputConnector();
        } else if (mediator instanceof RMSequenceMediator) {
            return ((RMSequenceMediator) mediator).getInputConnector();
        } else if (mediator instanceof RuleMediator) {
            return ((RuleMediator) mediator).getInputConnector();
        } else if (mediator instanceof ScriptMediator) {
            return ((ScriptMediator) mediator).getInputConnector();
        } else if (mediator instanceof org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) {
            return ((org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) mediator).getInputConnector();
        } else if (mediator instanceof SmooksMediator) {
            return ((SmooksMediator) mediator).getInputConnector();
        } else if (mediator instanceof SpringMediator) {
            return ((SpringMediator) mediator).getInputConnector();
        } else if (mediator instanceof StoreMediator) {
            return ((StoreMediator) mediator).getInputConnector();
        } else if (mediator instanceof SwitchMediator) {
            return ((SwitchMediator) mediator).getInputConnector();
        } else if (mediator instanceof ThrottleMediator) {
            return ((ThrottleMediator) mediator).getInputConnector();
        } else if (mediator instanceof XQueryMediator) {
            return ((XQueryMediator) mediator).getInputConnector();
        } else if (mediator instanceof XSLTMediator) {
            return ((XSLTMediator) mediator).getInputConnector();
        } else if (mediator instanceof FastXSLTMediator) {
            return ((FastXSLTMediator) mediator).getInputConnector();
        } else if (mediator instanceof BAMMediator) {
            return ((BAMMediator) mediator).getInputConnector();
        } else if (mediator instanceof Sequence) {
            return ((Sequence) mediator).getInputConnector();
        } else if (mediator instanceof CallMediator) {
            return ((CallMediator) mediator).getInputConnector();
        } else if (mediator instanceof LoopBackMediator) {
            return ((LoopBackMediator) mediator).getInputConnector();
        } else if (mediator instanceof RespondMediator) {
            return ((RespondMediator) mediator).getInputConnector();
        } else if (mediator instanceof ConditionalRouterMediator) {
            return ((ConditionalRouterMediator) mediator).getInputConnector();
        } else if (mediator instanceof ValidateMediator) {
            return ((ValidateMediator) mediator).getInputConnector();
        } else if (mediator instanceof BeanMediator) {
            return ((BeanMediator) mediator).getInputConnector();
        } else if (mediator instanceof EJBMediator) {
            return ((EJBMediator) mediator).getInputConnector();
        } else if (mediator instanceof URLRewriteMediator) {
            return ((URLRewriteMediator) mediator).getInputConnector();
        } else if (mediator instanceof TransactionMediator) {
            return ((TransactionMediator) mediator).getInputConnector();
        } else if (mediator instanceof ForEachMediator) {
            return ((ForEachMediator) mediator).getInputConnector();
        } else if (mediator instanceof BuilderMediator) {
            return ((BuilderMediator) mediator).getInputConnector();
        } else if (mediator instanceof PublishEventMediator) {
            return ((PublishEventMediator) mediator).getInputConnector();
        } else if (mediator instanceof CloudConnectorOperationImpl) {
            return ((CloudConnectorOperationImpl) mediator).getInputConnector();
        }
        throw new IllegalArgumentException("Invalid/Unknown Mediator type found : " + mediator.toString());
    }

    /**
     * This method returns the OutputConnector of the given mediator.
     * 
     * @param mediator
     * @return
     */
    public static OutputConnector getOutputConnectorFromMediator(org.wso2.developerstudio.eclipse.gmf.esb.Mediator mediator) {

        if (mediator instanceof AggregateMediator) {
            return ((AggregateMediator) mediator).getOutputConnector();
        } else if (mediator instanceof CacheMediator) {
            return ((CacheMediator) mediator).getOutputConnector();
        } else if (mediator instanceof CalloutMediator) {
            return ((CalloutMediator) mediator).getOutputConnector();
        } else if (mediator instanceof CallTemplateMediator) {
            return ((CallTemplateMediator) mediator).getOutputConnector();
        } else if (mediator instanceof ClassMediator) {
            return ((ClassMediator) mediator).getOutputConnector();
        } else if (mediator instanceof CloneMediator) {
            return ((CloneMediator) mediator).getOutputConnector();
        } else if (mediator instanceof CommandMediator) {
            return ((CommandMediator) mediator).getOutputConnector();
        } else if (mediator instanceof DBLookupMediator) {
            return ((DBLookupMediator) mediator).getOutputConnector();
        } else if (mediator instanceof DBReportMediator) {
            return ((DBReportMediator) mediator).getOutputConnector();
        } else if (mediator instanceof EnqueueMediator) {
            return ((EnqueueMediator) mediator).getOutputConnector();
        } else if (mediator instanceof EnrichMediator) {
            return ((EnrichMediator) mediator).getOutputConnector();
        } else if (mediator instanceof Sequence) {
            return ((Sequence) mediator).getOutputConnector().get(0);
        } else if (mediator instanceof EntitlementMediator) {
            return ((EntitlementMediator) mediator).getOutputConnector();
        } else if (mediator instanceof EventMediator) {
            return ((EventMediator) mediator).getOutputConnector();
        } else if (mediator instanceof FaultMediator) {
            return ((FaultMediator) mediator).getOutputConnector();
        } else if (mediator instanceof FilterMediator) {
            return ((FilterMediator) mediator).getOutputConnector();
        } else if (mediator instanceof HeaderMediator) {
            return ((HeaderMediator) mediator).getOutputConnector();
        } else if (mediator instanceof IterateMediator) {
            return ((IterateMediator) mediator).getOutputConnector();
        } else if (mediator instanceof LogMediator) {
            return ((LogMediator) mediator).getOutputConnector();
        } else if (mediator instanceof OAuthMediator) {
            return ((OAuthMediator) mediator).getOutputConnector();
        } else if (mediator instanceof PayloadFactoryMediator) {
            return ((PayloadFactoryMediator) mediator).getOutputConnector();
        } else if (mediator instanceof PropertyMediator) {
            return ((PropertyMediator) mediator).getOutputConnector();
        } else if (mediator instanceof RMSequenceMediator) {
            return ((RMSequenceMediator) mediator).getOutputConnector();
        } else if (mediator instanceof RuleMediator) {
            return ((RuleMediator) mediator).getOutputConnector();
        } else if (mediator instanceof ScriptMediator) {
            return ((ScriptMediator) mediator).getOutputConnector();
        } else if (mediator instanceof org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) {
            return ((org.wso2.developerstudio.eclipse.gmf.esb.SendMediator) mediator).getOutputConnector();
        } else if (mediator instanceof SmooksMediator) {
            return ((SmooksMediator) mediator).getOutputConnector();
        } else if (mediator instanceof SpringMediator) {
            return ((SpringMediator) mediator).getOutputConnector();
        } else if (mediator instanceof StoreMediator) {
            return ((StoreMediator) mediator).getOutputConnector();
        } else if (mediator instanceof SwitchMediator) {
            return ((SwitchMediator) mediator).getOutputConnector();
        } else if (mediator instanceof ThrottleMediator) {
            return ((ThrottleMediator) mediator).getOutputConnector();
        } else if (mediator instanceof XQueryMediator) {
            return ((XQueryMediator) mediator).getOutputConnector();
        } else if (mediator instanceof XSLTMediator) {
            return ((XSLTMediator) mediator).getOutputConnector();
        } else if (mediator instanceof FastXSLTMediator) {
            return ((FastXSLTMediator) mediator).getOutputConnector();
        } else if (mediator instanceof BAMMediator) {
            return ((BAMMediator) mediator).getOutputConnector();
        } else if (mediator instanceof CallMediator) {
            return ((CallMediator) mediator).getOutputConnector();
        } else if (mediator instanceof LoopBackMediator) {
            return ((LoopBackMediator) mediator).getOutputConnector();
        } else if (mediator instanceof RespondMediator) {
            return ((RespondMediator) mediator).getOutputConnector();
        } else if (mediator instanceof ConditionalRouterMediator) {
            return ((ConditionalRouterMediator) mediator).getOutputConnector();
        } else if (mediator instanceof ValidateMediator) {
            return ((ValidateMediator) mediator).getOutputConnector();
        } else if (mediator instanceof BeanMediator) {
            return ((BeanMediator) mediator).getOutputConnector();
        } else if (mediator instanceof EJBMediator) {
            return ((EJBMediator) mediator).getOutputConnector();
        } else if (mediator instanceof URLRewriteMediator) {
            return ((URLRewriteMediator) mediator).getOutputConnector();
        } else if (mediator instanceof TransactionMediator) {
            return ((TransactionMediator) mediator).getOutputConnector();
        } else if (mediator instanceof ForEachMediator) {
            return ((ForEachMediator) mediator).getOutputConnector();
        } else if (mediator instanceof BuilderMediator) {
            return ((BuilderMediator) mediator).getOutputConnector();
        } else if (mediator instanceof PublishEventMediator) {
            return ((PublishEventMediator) mediator).getOutputconnector();
        } else if (mediator instanceof CloudConnectorOperationImpl) {
            return ((CloudConnectorOperationImpl) mediator).getOutputConnector();
        }
        throw new IllegalArgumentException("Invalid/Unknown Mediator type found : " + mediator.toString());
    }
	
	public static AbstractMediatorInputConnectorEditPart getMediatorInputConnector(ShapeNodeEditPart parent){
		if(parent!=null){
			for(int i=0;i<parent.getChildren().size();++i){					
				if(parent.getChildren().get(i) instanceof AbstractMediatorInputConnectorEditPart){
					return (AbstractMediatorInputConnectorEditPart) parent.getChildren().get(i);
				}
			}
		}
		return null;
	}
	
	public static AbstractMediatorOutputConnectorEditPart getMediatorOutputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AbstractMediatorOutputConnectorEditPart){
				return (AbstractMediatorOutputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<AdditionalOutputConnector> getMediatorAdditionalOutputConnectors(ShapeNodeEditPart parent){
		ArrayList<AdditionalOutputConnector> connectors=new ArrayList<AdditionalOutputConnector>();
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AdditionalOutputConnector){
				connectors.add((AdditionalOutputConnector) parent.getChildren().get(i));
			}
		}
		return connectors;
	}
	
	
	public static AbstractEndpointInputConnectorEditPart getEndpointInputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AbstractEndpointInputConnectorEditPart){
				return (AbstractEndpointInputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static AbstractEndpointOutputConnectorEditPart getEndpointOutputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AbstractEndpointOutputConnectorEditPart){
				return (AbstractEndpointOutputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static AbstractProxyServiceContainerEditPart getProxyContainer(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof AbstractProxyServiceContainerEditPart){
				return (AbstractProxyServiceContainerEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	
	public static AbstractInputConnectorEditPart getProxyFaultInputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof ProxyFaultInputConnectorEditPart){
				return (ProxyFaultInputConnectorEditPart) parent.getChildren().get(i);
			}else if(parent.getChildren().get(i) instanceof APIResourceFaultInputConnectorEditPart){
				return (APIResourceFaultInputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static AbstractOutputConnectorEditPart getProxyOutSequenceOutputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof ProxyOutSequenceOutputConnectorEditPart){
				return (ProxyOutSequenceOutputConnectorEditPart) parent.getChildren().get(i);
			}else if(parent.getChildren().get(i) instanceof APIResourceOutSequenceOutputConnectorEditPart){
				return (APIResourceOutSequenceOutputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static AbstractInputConnectorEditPart getBaseFigureInputConnector(ShapeNodeEditPart parent){
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof ProxyInputConnectorEditPart){
				return (ProxyInputConnectorEditPart) parent.getChildren().get(i);
			}else if(parent.getChildren().get(i) instanceof APIResourceInputConnectorEditPart){
				return (APIResourceInputConnectorEditPart) parent.getChildren().get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<ComplexEndpointsOutputConnectorEditPart> getComplexEndpointsOutputConnectors(ComplexEndpointsEditPart parent){
		ArrayList<ComplexEndpointsOutputConnectorEditPart> outputConnectors=new ArrayList<ComplexEndpointsOutputConnectorEditPart>();
		
		for(int i=0;i<parent.getChildren().size();++i){					
			if(parent.getChildren().get(i) instanceof ComplexEndpointsOutputConnectorEditPart){
				outputConnectors.add((ComplexEndpointsOutputConnectorEditPart) parent.getChildren().get(i));
			}
		}
		return outputConnectors;
	}
	
	public static AbstractMediator getMediator(EditPart compartment){
		EditPart child=compartment;
		while ((child.getParent()!=null)&&!(child.getParent() instanceof AbstractMediator)){
			child=child.getParent();
		}		
		if(child.getParent()!=null){
			return (AbstractMediator) child.getParent();
		}else{
			return null;
		}
	}
	
	public static EditPart getComplexMediator(EditPart compartment){
		EditPart editPart=compartment;
		if(editPart instanceof MediatorFlowMediatorFlowCompartment7EditPart 		// filter pass
				|| editPart instanceof MediatorFlowMediatorFlowCompartment8EditPart		// filter fail
				|| editPart instanceof MediatorFlowMediatorFlowCompartment9EditPart		// throttle onaccept
				|| editPart instanceof MediatorFlowMediatorFlowCompartment10EditPart	// throttle onreject
				|| editPart instanceof MediatorFlowMediatorFlowCompartment11EditPart) { // clone target
			return editPart.getParent().getParent().getParent().getParent();
		} else if (editPart instanceof MediatorFlowMediatorFlowCompartment2EditPart		// switch case
				|| editPart instanceof MediatorFlowMediatorFlowCompartment4EditPart	) { // switch default
			return editPart.getParent().getParent().getParent().getParent().getParent();
		}
		else {
				return null;
		}
	}
	
	/*
	 * You can get the MediatorEditPart of the entered ConnectorEditPart using this method.
	 */
	public static AbstractMediator getMediator(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof AbstractMediator))){
			temp=temp.getParent();			
		}
		if(temp instanceof AbstractMediator){
			return (AbstractMediator) temp;
		}
		else{
			return null;
		}
	}
	
	public static AbstractEndpoint getEndpoint(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof AbstractEndpoint))){
			temp=temp.getParent();			
		}
		if(temp instanceof AbstractEndpoint){
			return (AbstractEndpoint) temp;
		}
		else{
			return null;
		}
	}
	
	public static ProxyServiceEditPart getProxy(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof ProxyServiceEditPart))){
			temp=temp.getParent();			
		}
		if(temp instanceof ProxyServiceEditPart){
			return (ProxyServiceEditPart) temp;
		}
		else{
			return null;
		}
	}
	
	public static ProxyServiceEditPart getProxy(EditPart child){
		while ((child.getParent()!=null)&&!(child.getParent() instanceof ProxyServiceEditPart)){
			child=child.getParent();
		}		
		if(child.getParent()!=null){
			return (ProxyServiceEditPart) child.getParent();
		}else{
			return null;
		}
	}
	
	public static AbstractBaseFigureEditPart getAbstractBaseFigureEditPart(EditPart child){
		while ((child.getParent()!=null)&&!(child.getParent() instanceof AbstractBaseFigureEditPart)){
			child=child.getParent();
		}		
		if(child.getParent()!=null){
			return (AbstractBaseFigureEditPart) child.getParent();
		}else{
			return null;
		}
	}
	
	public static IGraphicalEditPart getRootContainer(EditPart child) {
		while ((child.getParent() != null)
				&& !(child.getParent() instanceof AbstractBaseFigureEditPart)) {
			child = child.getParent();
		}
		if (child.getParent() != null) {
			return (IGraphicalEditPart) child.getParent();
		} else {
			return null;
		}
	}
	
	public static EObject getRootContainerModel(EObject child) {
		while ((child.eContainer() != null)
				&& !(child.eContainer() instanceof ProxyService || child.eContainer() instanceof APIResource)) {
			child = child.eContainer();
		}
		if (child.eContainer() != null) {
			return (EObject) child.eContainer();
		} else {
			return null;
		}
	}
	
	public static MediatorFlowMediatorFlowCompartmentEditPart getSequenceAndEndpointCompartmentEditPart(EditPart child){
		while ((child.getParent()!=null)&&!(child.getParent() instanceof MediatorFlowMediatorFlowCompartmentEditPart)){
			child=child.getParent();
		}		
		if(child.getParent()!=null){
			return (MediatorFlowMediatorFlowCompartmentEditPart) child.getParent();
		}else{
			return null;
		}
	}	
	
	public static AbstractSequencesEditPart getSequence(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof AbstractSequencesEditPart))){
			temp=temp.getParent();			
		}
		if(temp instanceof AbstractSequencesEditPart){
			return (AbstractSequencesEditPart) temp;
		}
		else{
			return null;
		}
	}
	
	public static ComplexEndpointsEditPart getComplexEndpoint(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof ComplexEndpointsEditPart))){
			temp=temp.getParent();			
		}
		if(temp instanceof ComplexEndpointsEditPart){
			return (ComplexEndpointsEditPart) temp;
		}
		else{
			return null;
		}
	}
	
	public static APIResourceEditPart getAPIResource(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof APIResourceEditPart))){
			temp=temp.getParent();			
		}
		if(temp instanceof APIResourceEditPart){
			return (APIResourceEditPart) temp;
		}
		else{
			return null;
		}
	}
	
	public static InboundEndpointEditPart getInboundEndpoint(AbstractConnectorEditPart connector){
		EditPart temp=connector;
		while((temp !=null)&&(!(temp instanceof InboundEndpointEditPart))){
			temp=temp.getParent();			
		}
		if(temp instanceof InboundEndpointEditPart){
			return (InboundEndpointEditPart) temp;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Sets the status of the lock attribute.
	 * @param editor
	 * @param lockmode
	 */
	public static void setLockmode(EsbDiagramEditor editor, boolean lockmode) {
		EsbServer esbServer = getEsbServer(editor);
		if (esbServer != null) {
			esbServer.setLockmode(lockmode);
		}

	}

	/**
	 * Returns the status of the lock attribute.
	 * @param editor
	 * @return
	 */
	public static boolean isLockmode(EsbDiagramEditor editor) {
		EsbServer esbServer = getEsbServer(editor);
		if (esbServer != null) {
			return esbServer.isLockmode();
		}
		return false;
	}
	
	/**
	 * Sets the status of the lock attribute.
	 * @param editPart
	 * @param lockmode
	 */
	public static void setLockmode(GraphicalEditPart editPart, boolean lockmode) {
		EsbServer esbServer = getEsbServer(editPart);
		if (esbServer != null) {
			esbServer.setLockmode(lockmode);
		}

	}

	/**
	 * Returns the status of the lock attribute.
	 * @param editPart
	 * @return
	 */
	public static boolean isLockmode(GraphicalEditPart editPart) {
		EsbServer esbServer = getEsbServer(editPart);
		if (esbServer != null) {
			return esbServer.isLockmode();
		}
		return false;
	}

	/**
	 * Returns the EsbServer model
	 * @param editor
	 * @return
	 */
	public static EsbServer getEsbServer(EsbDiagramEditor editor) {
		Diagram diagram = editor.getDiagram();
		EsbDiagram esbDiagram = (EsbDiagram) diagram.getElement();
		EsbServer esbServer = esbDiagram.getServer();
		return esbServer;
	}
	
	/**
	 * Returns the EsbServer model
	 * @param editPart
	 * @return
	 */
	public static EsbServer getEsbServer(GraphicalEditPart editPart) {
		RootEditPart root = editPart.getRoot();
		if (root.getChildren().size() == 1
				&& root.getChildren().get(0) instanceof EsbDiagramEditPart) {
			EsbDiagramEditPart EsbDiagramEditPart = (EsbDiagramEditPart) root.getChildren().get(0);
			EsbDiagram esbDiagram = (EsbDiagram) ((View) EsbDiagramEditPart.getModel())
					.getElement();
			EsbServer esbServer = esbDiagram.getServer();
			return esbServer;
		}
		return null;
	}

	public static void updateToolpalette() {
		Display.getDefault().asyncExec(new Runnable() {			
			public void run() {
				IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().getEditorReferences();
				IEditorPart activeEditor=PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor();
				for (int i = 0; i < editorReferences.length; i++) {
					IEditorPart editor = editorReferences[i].getEditor(false);
					if ((editor instanceof EsbMultiPageEditor)) {
				        /*
				         * This must be altered. 'addDefinedSequences' and 'addDefinedEndpoints' methods should not exist inside EsbPaletteFactory class. 
				         * Creating new instance of 'EsbPaletteFactory' must be avoided.
				         */
						EsbPaletteFactory esbPaletteFactory=new EsbPaletteFactory();
						if(!editor.equals(activeEditor)){					        
					        esbPaletteFactory.addDefinedSequences(((EsbMultiPageEditor) editor).getGraphicalEditor());
					        esbPaletteFactory.addDefinedEndpoints(((EsbMultiPageEditor) editor).getGraphicalEditor());					        
						}else{
							//esbPaletteFactory.addCloudConnectorOperations(((EsbMultiPageEditor) editor).getGraphicalEditor());
						}
						try {
							EsbEditorInput input = (EsbEditorInput) ((EsbMultiPageEditor) editor).getGraphicalEditor().getEditorInput();
							IFile file = input.getXmlResource();
							IProject activeProject = file.getProject();
							if(CloudConnectorDirectoryTraverser.getInstance().validate(activeProject)){
								addCloudConnectorOperations(((EsbMultiPageEditor) editor).getGraphicalEditor(), esbPaletteFactory);
							}	
						} catch (Exception e) {
						 MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
									 "Developer Studio Error Dialog", "Error while loading the connector due to "+e.getMessage());							 
						}
						
						// Initialize palette viewer key handler. 
						PaletteViewer paletteViewer = ((DiagramEditDomain) ((EsbMultiPageEditor) editor).getGraphicalEditor().getDiagramEditDomain())
								.getPaletteViewer();
						if(paletteViewer.getKeyHandler() instanceof CustomPaletteViewerKeyHandler) {
							((CustomPaletteViewerKeyHandler)paletteViewer.getKeyHandler()).initializeKeyHandler();	
						}
					}
				}
			}
		});
	}
	
	
	private static void addCloudConnectorOperations(EsbDiagramEditor editorPart,EsbPaletteFactory esbPaletteFactory) throws Exception{
		EsbEditorInput input = (EsbEditorInput) editorPart.getEditorInput();
		IFile file = input.getXmlResource();
		IProject activeProject = file.getProject();
		
		//String connectorDirectory=activeProject.getWorkspace().getRoot().getLocation().toOSString()+File.separator+"cloudConnectors";
		String connectorDirectory = activeProject.getWorkspace().getRoot().getLocation()
				.toOSString()
				+ File.separator + CloudConnectorDirectoryTraverser.connectorPathFromWorkspace;
		File directory=new File(connectorDirectory);
		if(directory.isDirectory()){
			File[] children=directory.listFiles();
	        for(int i=0;i<children.length;++i){
	        	if(children[i].isDirectory()){
	        		esbPaletteFactory.addCloudConnectorOperations(editorPart, children[i].getName());
	        	}
	        }
		}

	}
	
	/**
	 * A utility method to remove currently unsupported mediators/flows from a
	 * sequence
	 * 
	 * @param sequence
	 * @return
	 */
	public static SequenceMediator stripUnsupportedMediators(SequenceMediator sequence) {
		SequenceMediator newSequence = new SequenceMediator();
		for (Iterator<Mediator> i = sequence.getList().iterator(); i.hasNext();) {
			Mediator next = i.next();
			newSequence.addChild(next);
			if (next instanceof SendMediator) {
				/*
				 * current impemetaion does not support any mediator after send
				 * mediator in given sequence, this might be changed in next
				 * releases
				 */
				break;
			}

		}
		return newSequence;
	}
	
	/**
	 * Returns true if the flow has a cycle. but returning false does not
	 * guarantee that it hasn't cycles
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean hasCycle(EditPart source, EditPart target) {
		for (EditPart next = target; next != null; next = getNextNode(next)) {
			if (next instanceof AbstractEndpoint || next instanceof SequencesEditPart
					|| next instanceof Sequences2EditPart) {
				break;
			}
			if (next == source) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the next element in the node flow.
	 */
	private static EditPart getNextNode(EditPart node) {
		EditPart next = null;
		if (node instanceof ShapeNodeEditPart) {
			AbstractOutputConnectorEditPart nextOutputConnector = EditorUtils
					.getOutputConnector((ShapeNodeEditPart) node);
			if (nextOutputConnector != null) {
				/*
				 * List<EsbLinkEditPart> connections = nextOutputConnector
				 * .getTargetConnections(); for (EsbLinkEditPart object :
				 * connections) { if(object.getTarget() instanceof EditPart){
				 * return object.getTarget().getParent(); } }
				 */
				@SuppressWarnings("unchecked")
				List<EsbLinkEditPart> connections = nextOutputConnector.getSourceConnections();
				for (EsbLinkEditPart object : connections) {
					/* At the moment, we are not going to handle multipe links */
					if (object.getTarget() instanceof EditPart) {
						return object.getTarget().getParent();
					}
				}
			}
		}
		return next;
	}
	
	/**
	 * Returns true if source and target are connectable
	 * @param source
	 * @param target
	 * @return
	 * FIXME: please improve
	 */
	public static boolean isConnectableTarget(EditPart source, EditPart target) {
		if (source.getParent() instanceof ShapeCompartmentEditPart
				&& target.getParent() instanceof ShapeCompartmentEditPart) {
			ShapeCompartmentEditPart sourceCompartment = (ShapeCompartmentEditPart) source
					.getParent();
			ShapeCompartmentEditPart targetCompartment = (ShapeCompartmentEditPart) target
					.getParent();
			if (sourceCompartment == targetCompartment) {
				return true;
			} else if (isChildOfTarget(sourceCompartment, targetCompartment)
					|| isChildOfTarget(targetCompartment, sourceCompartment)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns true if the source is a child of target. 
	 * FIXME: please improve
	 */
	private static boolean isChildOfTarget(EditPart source, EditPart target) {
		EditPart parent = target;
		while ((parent = parent.getParent()) != null) {
			if (parent == source) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Return the active project
	 */
	public static IProject getActiveProject() {
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
				EsbEditorInput input = (EsbEditorInput) editorPart.getEditorInput();
				IFile file = input.getXmlResource();
				activeProject = file.getProject();

			}
		}
		return activeProject;
	}
	
	/**
	 * This method made for fix JIRA Tools 3213. This method calls in
	 * SequenceEditPart to create new sequence. This only returns most close
	 * ESBConfig project to the artifact.
	 * 
	 * @return
	 * @throws CoreException
	 */
    public static IProject getActiveProjectSafemode() throws CoreException {

        IEditorPart editorPart = null;
        IProject activeProject = null;
        IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .getEditorReferences();
        IFile file = null;
        for (IEditorReference editorReference : editorReferences) {
            IEditorPart editor = editorReference.getEditor(false);
            if (editor != null) {
                editorPart = editor.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
                if (editorPart != null) {
                    EsbEditorInput input = (EsbEditorInput) editorPart.getEditorInput();
                    file = input.getXmlResource();
                    activeProject = file.getProject();
                }
            }
        }
        if (!(activeProject.hasNature(Constants.ESB_PROJECT_NATURE) || activeProject
                .hasNature(Constants.GENERAL_PROJECT_NATURE))) {
            activeProject = getParentESBProject(file);
        }
        return activeProject;
    }

	private static IProject getParentESBProject(IFile file) {
		IPath path = file.getFullPath();
		path = path.removeLastSegments(NUMBER_OF_SEGMENTS_IN_PATH_AFTER_ESBCONFIG_PROJECT);
		String name = path.lastSegment();
		return ResourcesPlugin.getWorkspace().getRoot().getProject(name);
	}
	/**
	 * Return the active editor
	 */
	public static IEditorPart getActiveEditor() {
		IEditorPart editorPart = null;
		IEditorReference editorReferences[] = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getEditorReferences();
		for (int i = 0; i < editorReferences.length; i++) {
			IEditorPart editor = editorReferences[i].getEditor(false);
			if (editor != null) {
				editorPart = editor.getSite().getWorkbenchWindow().getActivePage()
						.getActiveEditor();
			}
		}
		return editorPart;
	}
	
	public static ShapeNodeEditPart getChildContainer(MultipleCompartmentComplexFiguredAbstractMediator mediator) {
		
		if (mediator instanceof SwitchMediatorEditPart) {
			
			for(int i=0;i<mediator.getChildren().size();++i){					
				if(mediator.getChildren().get(i) instanceof SwitchMediatorContainerEditPart){
					return (SwitchMediatorContainerEditPart) mediator.getChildren().get(i);
				}
			} 
		}else if (mediator instanceof FilterMediatorEditPart) {
			
			for(int i=0;i<mediator.getChildren().size();++i){					
				if(mediator.getChildren().get(i) instanceof FilterContainerEditPart){
					return (FilterContainerEditPart) mediator.getChildren().get(i);
				}
			}
		}else if (mediator instanceof ThrottleMediatorEditPart) {
			
			for(int i=0;i<mediator.getChildren().size();++i){					
				if(mediator.getChildren().get(i) instanceof ThrottleContainerEditPart){
					return (ThrottleContainerEditPart) mediator.getChildren().get(i);
				}
			}
		}else if (mediator instanceof CloneMediatorEditPart) {
			
			for(int i=0;i<mediator.getChildren().size();++i){					
				if(mediator.getChildren().get(i) instanceof CloneMediatorContainerEditPart){
					return (CloneMediatorContainerEditPart) mediator.getChildren().get(i);
				}
			}
		}else if (mediator instanceof EntitlementMediatorEditPart) {
			
			for(int i=0;i<mediator.getChildren().size();++i){					
				if(mediator.getChildren().get(i) instanceof EntitlementContainerEditPart){
					return (EntitlementContainerEditPart) mediator.getChildren().get(i);
				}
			}
		}
	
		return null;
	}
	
    public static boolean isAChildOf(AbstractMediator parentMediator, AbstractMediator thisMediator) {
		if(parentMediator instanceof MultipleCompartmentComplexFiguredAbstractMediator){
			List<EditPart> childEditParts = new ArrayList<EditPart>();
			ShapeNodeEditPart childContainer = getChildContainer((MultipleCompartmentComplexFiguredAbstractMediator)parentMediator);
			if (childContainer instanceof SwitchMediatorContainerEditPart) {
				List<EditPart> caseEditParts = ((SwitchCaseParentContainerEditPart)childContainer.getChildren().get(0)).getChildren();
				List<EditPart> defaultEditParts = ((SwitchDefaultParentContainerEditPart)childContainer.getChildren().get(1)).getChildren();
				for (EditPart caseEditPart : caseEditParts) {
					childEditParts.add(caseEditPart);
				}
				for (EditPart defaultEditPart : defaultEditParts) {
					childEditParts.add(defaultEditPart);
				}
			} else {
				childEditParts =  childContainer.getChildren();
			}

			for (EditPart editPart : childEditParts) {
				IGraphicalEditPart mediatorFlow = (IGraphicalEditPart)editPart.getChildren().get(0);
				IGraphicalEditPart mediatorFlowCompartment = (IGraphicalEditPart)mediatorFlow.getChildren().get(0);
				if (mediatorFlowCompartment.getChildren().size() >= 1) {
					for (int i = 0; i < mediatorFlowCompartment.getChildren().size(); ++i) {
						AbstractMediator gep = (AbstractMediator) mediatorFlowCompartment.getChildren().get(i);
						if (gep.equals(thisMediator)) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
}
