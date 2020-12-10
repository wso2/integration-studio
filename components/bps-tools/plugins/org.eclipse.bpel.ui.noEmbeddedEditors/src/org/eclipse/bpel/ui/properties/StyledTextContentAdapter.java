package org.eclipse.bpel.ui.properties;

import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.IControlContentAdapter2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

public class StyledTextContentAdapter implements IControlContentAdapter,
		IControlContentAdapter2 {

	 private static final boolean COMPUTE_TEXT_USING_CLIENTAREA = !"carbon".equals(SWT.getPlatform()); //$NON-NLS-1$

     /*
      * (non-Javadoc)
      * 
      * @see
      * org.eclipse.jface.dialogs.taskassistance.IControlContentAdapter#getControlContents(org.eclipse.swt.widgets.Control
      * )
      */
     public String getControlContents(Control control) {
             return ((StyledText) control).getText();
     }

     /*
      * (non-Javadoc)
      * 
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter#setControlContents(org.eclipse.swt.widgets.Control,
      * java.lang.String, int)
      */
     public void setControlContents(Control control, String text, int cursorPosition) {
             ((StyledText) control).setText(text);
             ((StyledText) control).setSelection(new Point(cursorPosition, cursorPosition));
     }

     /*
      * (non-Javadoc)
      * 
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter#insertControlContents(org.eclipse.swt.widgets.Control,
      * java.lang.String, int)
      */
     public void insertControlContents(Control control, String text, int cursorPosition) {
             final StyledText combo = (StyledText) control;
             final String contents = combo.getText();
             final Point selection = combo.getSelection();
             final StringBuffer sb = new StringBuffer();
             sb.append(contents.substring(0, selection.x));
             sb.append(text);
             if (selection.y < contents.length()) {
                     sb.append(contents.substring(selection.y, contents.length()));
             }
             combo.setText(sb.toString());
             selection.x = selection.x + cursorPosition;
             selection.y = selection.x;
             combo.setSelection(selection);
     }

     /*
      * (non-Javadoc)
      * 
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter#getCursorPosition(org.eclipse.swt.widgets.Control)
      */
     public int getCursorPosition(Control control) {
             return ((StyledText) control).getSelection().x;
     }

     /*
      * (non-Javadoc)
      * 
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter#getInsertionBounds(org.eclipse.swt.widgets.Control)
      */
     public Rectangle getInsertionBounds(Control control) {
             // This doesn't take horizontal scrolling into affect.
             // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=204599
             final StyledText combo = (StyledText) control;
             final int position = combo.getSelection().y;
             final String contents = combo.getText();
             final GC gc = new GC(combo);
             gc.setFont(combo.getFont());
             final Point extent = gc.textExtent(contents.substring(0, Math.min(position, contents.length())));
             gc.dispose();
             if (COMPUTE_TEXT_USING_CLIENTAREA) {
                     return new Rectangle(combo.getClientArea().x + extent.x, combo.getClientArea().y, 1,
                                     combo.getClientArea().height);
             }
             return new Rectangle(extent.x, 0, 1, combo.getSize().y);
     }

     /*
      * (non-Javadoc)
      * 
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter#setCursorPosition(org.eclipse.swt.widgets.Control, int)
      */
     public void setCursorPosition(Control control, int index) {
             ((StyledText) control).setSelection(new Point(index, index));
     }

     /**
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter2#getSelection(org.eclipse.swt.widgets.Control)
      */
     public Point getSelection(Control control) {
             return ((StyledText) control).getSelection();
     }

     /**
      * @see org.eclipse.jface.fieldassist.IControlContentAdapter2#setSelection(org.eclipse.swt.widgets.Control,
      *      org.eclipse.swt.graphics.Point)
      */
     public void setSelection(Control control, Point range) {
             ((StyledText) control).setSelection(range);
     }


}
