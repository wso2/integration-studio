/**
 * SupplierOrderServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v3  Built on : Apr 27, 2010 (12:11:11 UTC)
 */
package com.acme.shoppingcart.supplierservice;

import com.acme.shoppingcart.supplierservice.types.OrderResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SupplierOrderServiceSkeleton java skeleton for the axisService
 */
public class SupplierOrderServiceSkeleton {
    private static Log log = LogFactory.getLog(SupplierOrderServiceSkeleton.class);

    /**
     * Auto generated method signature
     *
     * @param orderRequest
     */

    public com.acme.shoppingcart.supplierservice.types.OrderResponse
           createOrder(com.acme.shoppingcart.supplierservice.types.OrderRequest orderRequest) {
        log.info("Order received: Item: " + orderRequest.getItemId() + " Quantity: " +
                orderRequest.getOrderQty() + " Date: " + orderRequest.getOrderDate());

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderOk(true);

        return orderResponse;
    }

}
    