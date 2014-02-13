<%@ page import="com.acme.shoppingcart.admin.AdminClient" %>
<%@ page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.activation.DataHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
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
        String categoryName = null;
        String description = null;		
        DataHandler image = null;
        Iterator iter = items.iterator();
        
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            String fieldName = item.getFieldName();
            if (item.isFormField()) {
                if (fieldName.equals("categoryName")) {
                    categoryName = item.getString();
                } else if (fieldName.equals("categoryDescripton")) {
                    description = item.getString();
                }
            } else {
            	if(fieldName.equals("imageFile")) {
                	image = new DataHandler(new CustomDataSource(item));
            	}
            }
        }
        
        AdminClient client = new AdminClient();
        boolean success = client.saveCategory(categoryName, description, image);
        if (success) {
            out.print("Category Saved Successfully.");
        } else {
            out.print("Error Saving Category.");
        }
    } catch (FileUploadException e) {
        e.printStackTrace();
        out.print("Error Saving Category.");
    }

%>