package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

public class ValidationUtil {
    
    public static boolean isInt(String str)  
    {  
      try  
      {  
       Integer.parseInt(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }  
    public static int  getInt(String str)  
    {  
      try  
      {  
    	  return Integer.parseInt(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return -1;  
      }  
    }  
}
