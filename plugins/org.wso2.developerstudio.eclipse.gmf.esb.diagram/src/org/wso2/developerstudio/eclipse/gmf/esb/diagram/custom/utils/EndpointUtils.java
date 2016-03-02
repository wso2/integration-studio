package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.DefaultEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.FailoverEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AddressEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DefaultEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FailoverEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoadBalanceEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TemplateEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.WSDLEndPointEditPart;

public class EndpointUtils {

		public static void addOutputConnectorsInitially(AbstractEndpoint child,TransactionalEditingDomain domain){
			if (child instanceof FailoverEndPointEditPart) {
				FailoverEndPointEditPart endpointEditPart = (FailoverEndPointEditPart) child;
				EObject parentEndpoint =
				                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
				if (((FailoverEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
					for (int i = 0; i < 2; ++i) {
						FailoverEndPointOutputConnector outputConnector =
						                                                  EsbFactory.eINSTANCE.createFailoverEndPointOutputConnector();
						AddCommand addCmd =
						                    new AddCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.FAILOVER_END_POINT__OUTPUT_CONNECTOR,
						                                   outputConnector);
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}
				if (((FailoverEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
					if (((FailoverEndPoint) parentEndpoint).getWestOutputConnector() == null) {
						SetCommand addCmd =
						                    new SetCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.FAILOVER_END_POINT__WEST_OUTPUT_CONNECTOR,
						                                   EsbFactory.eINSTANCE.createFailoverEndPointWestOutputConnector());
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}
			} else if (child instanceof LoadBalanceEndPointEditPart) {
				LoadBalanceEndPointEditPart endpointEditPart = (LoadBalanceEndPointEditPart) child;
				EObject parentEndpoint =
				                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
				if (((LoadBalanceEndPoint) parentEndpoint).getOutputConnector().size() == 0) {
					for (int i = 0; i < 2; ++i) {
						LoadBalanceEndPointOutputConnector outputConnector =
						                                                     EsbFactory.eINSTANCE.createLoadBalanceEndPointOutputConnector();
						AddCommand addCmd =
						                    new AddCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.LOAD_BALANCE_END_POINT__OUTPUT_CONNECTOR,
						                                   outputConnector);
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}
				if (((LoadBalanceEndPoint) parentEndpoint).getInputConnector().getIncomingLinks()
				                                          .size() == 0) {
					if (((LoadBalanceEndPoint) parentEndpoint).getWestOutputConnector() == null) {
						SetCommand addCmd =
						                    new SetCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.LOAD_BALANCE_END_POINT__WEST_OUTPUT_CONNECTOR,
						                                   EsbFactory.eINSTANCE.createLoadBalanceEndPointWestOutputConnector());
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}

			} else if (child instanceof DefaultEndPointEditPart) {
				DefaultEndPointEditPart endpointEditPart = (DefaultEndPointEditPart) child;
				EObject parentEndpoint =
				                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
				if (((DefaultEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
					if (((DefaultEndPoint) parentEndpoint).getOutputConnector() == null) {
						SetCommand addCmd =
						                    new SetCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.DEFAULT_END_POINT__OUTPUT_CONNECTOR,
						                                   EsbFactory.eINSTANCE.createDefaultEndPointOutputConnector());
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}
			} else if (child instanceof AddressEndPointEditPart) {
				AddressEndPointEditPart endpointEditPart = (AddressEndPointEditPart) child;
				EObject parentEndpoint =
				                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
				if (((AddressEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
					if (((AddressEndPoint) parentEndpoint).getOutputConnector() == null) {
						SetCommand addCmd =
						                    new SetCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.ADDRESS_END_POINT__OUTPUT_CONNECTOR,
						                                   EsbFactory.eINSTANCE.createAddressEndPointOutputConnector());
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}
			} else if (child instanceof WSDLEndPointEditPart) {
				WSDLEndPointEditPart endpointEditPart = (WSDLEndPointEditPart) child;
				EObject parentEndpoint =
				                         ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
				if (((WSDLEndPoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
					if (((WSDLEndPoint) parentEndpoint).getOutputConnector() == null) {
						SetCommand addCmd =
						                    new SetCommand(
						                                   domain,
						                                   parentEndpoint,
						                                   EsbPackage.Literals.WSDL_END_POINT__OUTPUT_CONNECTOR,
						                                   EsbFactory.eINSTANCE.createWSDLEndPointOutputConnector());
						if (addCmd.canExecute()) {
							domain.getCommandStack().execute(addCmd);
						}
					}
				}
			} else if (child instanceof TemplateEndpointEditPart) {
             TemplateEndpointEditPart endpointEditPart = (TemplateEndpointEditPart) child;
             EObject parentEndpoint =
                                      ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) (endpointEditPart).getModel()).getElement();
             if (((TemplateEndpoint) parentEndpoint).getInputConnector().getIncomingLinks().size() == 0) {
                     if (((TemplateEndpoint) parentEndpoint).getOutputConnector() == null) {
                             SetCommand addCmd =
                                                 new SetCommand(
                                                                domain,
                                                                parentEndpoint,
                                                                EsbPackage.Literals.TEMPLATE_ENDPOINT__OUTPUT_CONNECTOR,
                                                                EsbFactory.eINSTANCE.createTemplateEndpointOutputConnector());
                             if (addCmd.canExecute()) {
                                     domain.getCommandStack().execute(addCmd);
                             }
                     }
             }
			}

		}
}
