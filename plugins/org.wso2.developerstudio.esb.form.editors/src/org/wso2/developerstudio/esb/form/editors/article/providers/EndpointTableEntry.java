package org.wso2.developerstudio.esb.form.editors.article.providers;

public class EndpointTableEntry {
    private boolean isInline;
    private String endpointValue;

    public EndpointTableEntry(boolean isInline, String value) {
        this.isInline = isInline;
        this.endpointValue = value;
    }

    public boolean isInline() {
        return this.isInline;
    }

    public String getEndpointValue() {
        return this.endpointValue;
    }
}
