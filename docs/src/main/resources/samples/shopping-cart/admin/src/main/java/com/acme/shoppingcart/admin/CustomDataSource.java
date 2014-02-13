package com.acme.shoppingcart.admin;

import org.apache.commons.fileupload.FileItem;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CustomDataSource implements DataSource {

    private FileItem fileItem;

    public CustomDataSource(FileItem fileItem) {
        this.fileItem = fileItem;
    }
    public InputStream getInputStream() throws IOException {
        return fileItem.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return fileItem.getOutputStream();
    }

    public String getContentType() {
        return fileItem.getContentType();
    }

    public String getName() {
        return fileItem.getName();
    }
}
