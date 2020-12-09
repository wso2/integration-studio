package org.wso2.developerstudio.datamapper.diagram.custom.figure;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ImageHolder;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin;

public class EditPartDrawingHelper {
	public static Color FigureSelectedColor = new Color(null, 245, 243, 215);
	public static Color FigureNormalColor = new Color(null, 255, 255, 255);
	public static Color FigureSelectedBorderColor = new Color(null, 200, 200, 200);
	

	public static Image getImage(String iconPath, int width, int height) {
		ImageDescriptor mainImgDesc = DataMapperDiagramEditorPlugin
				.getBundledImageDescriptor(iconPath);
		Image image;
		if(mainImgDesc!=null){
			image =mainImgDesc.createImage();
		}else{
			image =new Image(Display.getDefault(), iconPath);
		}
		Image scaled = new Image(Display.getDefault(), width, height);
        GC gc = new GC(scaled);
        gc.setAntialias(SWT.ON);
        gc.setInterpolation(SWT.HIGH);
        gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 
        					0, 0, width, height);
        gc.dispose();
		return image;
	}
	
	public static ImageFigure getIconImageFigure(String iconPath, int width, int height)
	{
		Image img = getImage(iconPath, width, height);
		ImageFigure iconImageFigure = new ImageFigure(img);
		iconImageFigure.setSize(new Dimension(width, height));
		return iconImageFigure;
	}
	
	public static ImageFigure getEastArrowIcon(int width, int height)
	{
		ImageFigure img1 = new ImageFigure(ImageHolder.getInstance().getArrowEastImage());
		img1.setSize(new Dimension(width, height));
		return img1;
	}
	
	public static ImageFigure getWestArrowIcon(int width, int height)
	{
		ImageFigure img1 = new ImageFigure(ImageHolder.getInstance().getArrowWestImage());
		img1.setSize(new Dimension(width, height));
		return img1;
	}
}
