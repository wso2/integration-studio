/**
 * SupplierOrderServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v3  Built on : Apr 27, 2010 (12:11:11 UTC)
 */
package com.acme.shoppingcart.supplierservice;

/**
 * SupplierOrderServiceMessageReceiverInOut message receiver
 */

public class SupplierOrderServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver {


    public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
            throws org.apache.axis2.AxisFault {

        try {

            // get the implementation class for the Web Service
            Object obj = getTheImplementationObject(msgContext);

            SupplierOrderServiceSkeleton skel = (SupplierOrderServiceSkeleton) obj;
            //Out Envelop
            org.apache.axiom.soap.SOAPEnvelope envelope = null;
            //Find the axisOperation that has been set by the Dispatch phase.
            org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
            if (op == null) {
                throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
            }

            java.lang.String methodName;
            if ((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)) {


                if ("createOrder".equals(methodName)) {

                    com.acme.shoppingcart.supplierservice.types.OrderResponse orderResponse1 = null;
                    com.acme.shoppingcart.supplierservice.types.OrderRequest wrappedParam =
                            (com.acme.shoppingcart.supplierservice.types.OrderRequest) fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.acme.shoppingcart.supplierservice.types.OrderRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));

                    orderResponse1 =


                            skel.createOrder(wrappedParam)
                            ;

                    envelope = toEnvelope(getSOAPFactory(msgContext), orderResponse1, false);

                } else {
                    throw new java.lang.RuntimeException("method not found");
                }


                newMsgContext.setEnvelope(envelope);
            }
        }
        catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    //
    private org.apache.axiom.om.OMElement toOM(com.acme.shoppingcart.supplierservice.types.OrderRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.acme.shoppingcart.supplierservice.types.OrderRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.acme.shoppingcart.supplierservice.types.OrderResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.acme.shoppingcart.supplierservice.types.OrderResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.acme.shoppingcart.supplierservice.types.OrderResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {
        try {
            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

            emptyEnvelope.getBody().addChild(param.getOMElement(com.acme.shoppingcart.supplierservice.types.OrderResponse.MY_QNAME, factory));


            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
    }

    private com.acme.shoppingcart.supplierservice.types.OrderResponse wrapcreateOrder() {
        com.acme.shoppingcart.supplierservice.types.OrderResponse wrappedElement = new com.acme.shoppingcart.supplierservice.types.OrderResponse();
        return wrappedElement;
    }


    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }


    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (com.acme.shoppingcart.supplierservice.types.OrderRequest.class.equals(type)) {

                return com.acme.shoppingcart.supplierservice.types.OrderRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.acme.shoppingcart.supplierservice.types.OrderResponse.class.equals(type)) {

                return com.acme.shoppingcart.supplierservice.types.OrderResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }


    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

}//end of class
    