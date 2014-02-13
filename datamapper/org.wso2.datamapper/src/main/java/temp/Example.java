package temp;

import java.io.File;
import java.io.IOException;

import org.wso2.datamapper.core.DataMapper;

public class Example {

	public static void main(String[] args) throws IOException {
		
		DataMapper configHandler = new DataMapper();
		configHandler.doMapping(new File("./resource/mapping_rules"),new File("./resource/input.xml"),new File("./resource/inputSchema.avsc"),new File("./resource/outputSchema.avsc"));
		
	}

}
