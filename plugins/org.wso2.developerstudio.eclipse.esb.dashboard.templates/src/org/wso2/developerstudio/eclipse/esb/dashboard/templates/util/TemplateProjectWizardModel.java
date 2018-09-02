package org.wso2.developerstudio.eclipse.esb.dashboard.templates.util;

public class TemplateProjectWizardModel {
    
    private String pageTitle;
    
    private String pageDescription;
    
    private String windowTitle;

    private String wizardPageText;
    
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
    public String getPageTitle() {
        return pageTitle;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }
        
    public String getWizardPageText() {
        return wizardPageText;
    }

    public void setWizardPageText(String wizardPageText) {
        this.wizardPageText = wizardPageText;
    }

}
