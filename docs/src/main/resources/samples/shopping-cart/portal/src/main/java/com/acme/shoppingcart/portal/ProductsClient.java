package com.acme.shoppingcart.portal;


import com.acme.shoppingcart.portal.product.DataServiceFaultException;
import com.acme.shoppingcart.portal.product.ProductServiceStub;
import com.acme.shoppingcart.portal.product.types.Category;
import com.acme.shoppingcart.portal.product.types.Product;

import java.rmi.RemoteException;

/**
 * Client for handling products 
 */
public class ProductsClient {

    private ProductServiceStub stub;

    public ProductsClient() {
        try {
            stub = new ProductServiceStub(PortalUtils.getEndpoint("products.proxy.service"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product[] listProducts(String category) {
        try {
            Product[] products = stub.getProductsOfCategory(category);
            for (Product product : products) {
                PortalUtils.addImage(product.getProductCode(), product.getImage());
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Category[] listProductCategories() {
        try {
            return stub.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

	public Product getProduct(String productCode) {
		try {
            Product product = stub.getProductByCode(productCode)[0];
            PortalUtils.addImage(product.getProductCode(), product.getImage());
            return product;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (DataServiceFaultException e) {
			e.printStackTrace();
		}
		return null;
	}
}
