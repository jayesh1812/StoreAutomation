package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;


import api.endpoints.Routes;

public class ResusableComp {

	
	public String readAPIFromTextFile(String filePath) throws IOException {
		String path;
		String context = "";
		
		path = Routes.userPostTemp;
		FileInputStream fileInputStream = new FileInputStream(path);
		int character;
		while((character = fileInputStream.read()) != - 1) {
			context = context + String.valueOf(((char)character));
		}
		
		return context;
	}
}
