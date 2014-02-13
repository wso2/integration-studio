package com.acme.shoppingcart.admin;

import com.acme.shoppingcart.admin.product.AdminServiceStub;
import com.acme.shoppingcart.admin.product.DataServiceFaultException;
import com.acme.shoppingcart.admin.product.types.Category;
import com.acme.shoppingcart.admin.product.types.ProductE;
import org.apache.axis2.AxisFault;

import javax.activation.DataHandler;
import java.rmi.RemoteException;


public class AdminClient {


    private AdminServiceStub stub;

    public AdminClient() {
        try {
            stub = new AdminServiceStub(AdminUtils.getEndpoint());
        } catch (AxisFault axisFault) {

        }
    }

    public boolean saveCategory(String categoryName, String description, DataHandler image) {

        try {
            stub.addNewCategory(categoryName, description, image);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
        	e.printStackTrace();
        }
        return false;
    }

    //Azeez: Don't write code like this. A method having such a large number of params is unreadable & unmaintainable
    // Please look at ProductClient in the portal module
    public boolean saveProduct(String productCode, String productName, String categoryName,
                               String productVendor, String productDescription, int quantityInStock,
                               double price, int reorderLevel, int reorderQuantity,
                               DataHandler image) {

        try {
            stub.addNewProduct(productCode, productName, categoryName, productVendor,
                               productDescription, quantityInStock, price, reorderLevel,
                               reorderQuantity, image);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(String productCode, String productName, String categoryName,
            String productVendor, String productDescription, int quantityInStock,
            double price, int reorderLevel, int reorderQuantity,
            DataHandler image) {

			try {
			stub.updateProduct(productCode, productName, categoryName, productVendor,
			            productDescription, quantityInStock, price, reorderLevel,
			            reorderQuantity, image);
			return true;
			} catch (RemoteException e) {
			e.printStackTrace();
			} catch (DataServiceFaultException e) {
			e.printStackTrace();
			}
			return false;
	}
    
    
    public boolean deleteCategory(String categoryName) {

        try {
            stub.deleteCategory(categoryName);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ProductE[] getProductByCode(String code) {

        try {
            ProductE[] products = stub.getProductByCode(code);
            ImageUtils.addImage(products[0].getProductCode(), products[0].getImage());
            return products;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteProduct(String productCode) {

        try {
            stub.deleteProduct(productCode);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ProductE[] listProducts() {

        try {
        	 ProductE[] products = stub.getAllProducts();
            return products;
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category[] listProductCategories() {

        try {
            return stub.getAllCategories();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (DataServiceFaultException e) {
            e.printStackTrace();
        }
        return null;
    }
}
