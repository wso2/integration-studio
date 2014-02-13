/*                                                                             
 * Copyright 2004,2005 The Apache Software Foundation.                         
 *                                                                             
 * Licensed under the Apache License, Version 2.0 (the "License");             
 * you may not use this file except in compliance with the License.            
 * You may obtain a copy of the License at                                     
 *                                                                             
 *      http://www.apache.org/licenses/LICENSE-2.0                             
 *                                                                             
 * Unless required by applicable law or agreed to in writing, software         
 * distributed under the License is distributed on an "AS IS" BASIS,           
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    
 * See the License for the specific language governing permissions and         
 * limitations under the License.                                              
 */
package com.acme.shoppingcart.portal;

import com.acme.shoppingcart.portal.purchasing.PurchasingServiceStub;
import com.acme.shoppingcart.portal.purchasing.types.CustomerDetails;
import com.acme.shoppingcart.portal.purchasing.types.PurchaseOrder;

import java.rmi.RemoteException;

/**
 * Client for handling purchasing
 */
public class PurchasingClient {

    private PurchasingServiceStub stub;

    public PurchasingClient() {
        try {
            stub = new PurchasingServiceStub(PortalUtils.getEndpoint("purchasing.proxy.service"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkout(PurchaseOrder purchaseOrder, CustomerDetails customer) {
        try {
            stub.checkout(purchaseOrder, customer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
