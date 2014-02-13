<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="javax.activation.DataHandler" %>
<%@ page import="com.acme.shoppingcart.admin.CustomDataSource" %>
<%@ page import="org.apache.commons.fileupload.FileUploadException" %>

<%
    FileItemFactory factory = new DiskFileItemFactory();

    // Create a new file upload handler
    ServletFileUpload upload = new ServletFileUpload(factory);

    try {
        // Parse the request
        List items = upload.parseRequest(request);

        // Process the uploaded items
        String productCode = null;
        String productName = null;
        String categoryName = null;
        String productVendor = null;
        String productDescription = null;
        int quantityInStock = 0;

        double price = 0;
        int reorderLevel = 0;
        int reorderQuantity = 0;
        DataHandler image = null;
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            String fieldName = item.getFieldName();
            if (item.isFormField()) {
                if (fieldName.equals("code")) {
                    productCode = item.getString();
                } else if (fieldName.equals("productName")) {
                    productName = item.getString();
                } else if (fieldName.equals("description")) {
                    productDescription = item.getString();
                } else if (fieldName.equals("price")) {
                    price = Double.parseDouble(item.getString());
                } else if (fieldName.equals("reorderLevel")) {
                    reorderLevel = Integer.parseInt(item.getString());
                } else if (fieldName.equals("reorderQuantity")) {
                    reorderQuantity = Integer.parseInt(item.getString());
                } else if (fieldName.equals("categoryName")) {
                    categoryName = item.getString();
                } else if (fieldName.equals("productVendor")) {
                	productVendor = item.getString();
                } else if (fieldName.equals("quantityInStock")) {
                	quantityInStock = Integer.parseInt(item.getString());
                }
            } else {
            	if(fieldName.equals("imageFile")) {
                	image = new DataHandler(new CustomDataSource(item));
            	}
            }
        }

        AdminClient client = new AdminClient();
        boolean success = client.saveProduct(productCode, productName, categoryName, productVendor,
                                             productDescription, quantityInStock, price, reorderLevel,
                                             reorderQuantity, image);
        if (success) {
            out.print("Product Saved Successfully.");
        } else {
            out.print("Error Saving Product.");
        }
    } catch (FileUploadException e) {
        e.printStackTrace();
        out.print("Error Saving Product.");
    }
%>