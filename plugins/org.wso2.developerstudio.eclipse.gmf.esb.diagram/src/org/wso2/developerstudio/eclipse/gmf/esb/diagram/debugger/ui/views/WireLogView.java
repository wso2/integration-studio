package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBWirelog;

public class WireLogView extends ViewPart implements ContentAcceptHandler {

	private StyledText requestWireLogText;
	private StyledText responseWireLogText;
    private Color tableEvenIndexColor;

    @Override
    public void createPartControl(Composite parent) {
        Display display = PlatformUI.createDisplay();
        tableEvenIndexColor = display.getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW);
        
        Composite wireLogArea = new Composite(parent, SWT.NONE);
        wireLogArea.setLayout(new GridLayout(2, true));
        
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.horizontalSpan = 2;
        
        wireLogArea.setLayoutData(data);
        
//        GridLayout layout = new GridLayout(2, true);
//        parent.setLayout(layout);    
        
        

        
        
        Composite compositeRequet = new Composite(wireLogArea, SWT.BORDER);
        GridData gridDataReq = new GridData(SWT.FILL, SWT.FILL, true, true);
        compositeRequet.setLayoutData(gridDataReq);
        compositeRequet.setLayout(new GridLayout(1, false));
        
        Label requestLabel = new Label(compositeRequet, SWT.NONE);
        requestLabel.setText("Request Wire Log");
        
        requestWireLogText = new StyledText(compositeRequet, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
        requestWireLogText.setLayoutData(gridDataReq);
        requestWireLogText.setBackground(tableEvenIndexColor);
        
        
        Composite compositeResponse = new Composite(wireLogArea, SWT.BORDER);
        GridData gridDataRes = new GridData(SWT.FILL, SWT.FILL, true, true);
        compositeResponse.setLayoutData(gridDataRes);
        compositeResponse.setLayout(new GridLayout(1, false));
        
        Label responseLabel = new Label(compositeResponse, SWT.NONE);
        responseLabel.setText("Response Wire Log");
        
        responseWireLogText = new StyledText(compositeResponse, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
        responseWireLogText.setLayoutData(gridDataRes);
        responseWireLogText.setBackground(tableEvenIndexColor);
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void acceptContent(Object content, AcceptedContentAction action) {
    	setRequestResponseWireLogs(content);
    }
    
    private void setRequestResponseWireLogs(Object content) {
    	this.requestWireLogText.setText("");
    	this.requestWireLogText.update();
    	this.responseWireLogText.setText("");    	
    	this.responseWireLogText.update();
    	if (content == null) {    		
    		return;			
		}
    	
    	if (content instanceof ESBWirelog) {
    		ESBWirelog esbWireLog = (ESBWirelog) content;
    		this.requestWireLogText.setText(esbWireLog.getRequestWireLog());
        	this.requestWireLogText.update();
        	
        	this.responseWireLogText.setText(esbWireLog.getResponseWireLog());    	
        	this.responseWireLogText.update();
        }  
    	
    }
}
