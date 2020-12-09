package org.wso2.developerstudio.rcp.plugin.utils;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RCPPluginHandlerUtils {
    
    private static final String JAVA_VERSION_PROPERTY = "java.version";
    private static final String ALERT_TITLE = "Java Version Update Required";
    private static final String CONTINUE_BUTTON = "Continue";
    private static final String EXIT_BUTTON = "Exit";
    private static final String DOT_SEPARATOR = ".";
    
    
    /**
     * This method checks java version and popups a dialog box to select whether to
     * continue or exit
     * 
     * @param splashDisplay display element
     */
    public void showJavaVersionChecker(Display splashDisplay) {
        final String version = System.getProperty(JAVA_VERSION_PROPERTY);
        double detectedJavaVersion = getJavaVersionInDouble(version);
        final String warningMessage = "Detected java version " + detectedJavaVersion
                + " is not compatible with Developer Studio."
                + " Recommended JDK version is 1.8.x. Do you want to proceed with this version?.";
        final Display display = splashDisplay;
        // If Developer Studio starts with an unsupported version, then show a
        // warning
        if (detectedJavaVersion > 1.8) {
            display.asyncExec(new Runnable() {
                public void run() {
                    if (display != null) {
                        Shell shell = display.getActiveShell();
                        MessageDialog dialog = new MessageDialog(shell, ALERT_TITLE, null, warningMessage,
                                MessageDialog.ERROR, new String[] { CONTINUE_BUTTON, EXIT_BUTTON }, 0) {
                            protected void buttonPressed(int buttonId) {
                                if (buttonId == 1) {
                                    System.exit(0);
                                }
                                super.buttonPressed(buttonId);
                            }
                        };
                        dialog.open();
                    }
                }
            });
        }
    }

    /**
     * Method that returns Java version as a double value
     * For example, if 1.7.0_67 is given as input it will return 1.7
     * 
     * @param version Java version
     */
    private double getJavaVersionInDouble(String version) {
        String[] versionElements = version.split("\\.");
        String desiredVersionElements = versionElements[0] + DOT_SEPARATOR + versionElements[1];
        return Double.parseDouble(desiredVersionElements);
    }
}
