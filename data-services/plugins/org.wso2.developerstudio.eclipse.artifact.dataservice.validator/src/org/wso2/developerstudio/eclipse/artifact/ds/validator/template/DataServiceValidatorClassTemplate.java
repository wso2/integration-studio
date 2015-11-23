package org.wso2.developerstudio.eclipse.artifact.ds.validator.template;


public class DataServiceValidatorClassTemplate {

public static String getClassTemplete(String packgeName,String className){
		   try{
				StringBuffer buffer = new StringBuffer();
				buffer.append("package " + packgeName + ";\n\n");
				buffer.append("import org.wso2.carbon.dataservices.core.engine.ParamValue; \n");
				buffer.append("import org.wso2.carbon.dataservices.core.validation.ValidationContext; \n");
				buffer.append("import org.wso2.carbon.dataservices.core.validation.ValidationException; \n");
				buffer.append("import org.wso2.carbon.dataservices.core.validation.Validator;\n\n");
				buffer.append("public class " + className +" implements Validator { \n\n\t" );
				//buffer.append(" \n\t");
				buffer.append("public void validate(ValidationContext arg0, String arg1, ParamValue arg2) throws ValidationException { \n\t\t");
				buffer.append("// TODO Implement your logic here \n\t\t");
				buffer.append("\n\t");
				buffer.append("}\n}\n");
				return buffer.toString();
            }catch (Exception e){
              e.printStackTrace();
              return"";
            }
	}
}
