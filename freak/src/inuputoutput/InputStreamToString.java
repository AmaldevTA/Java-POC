package inuputoutput;

import java.io.InputStream;
import java.io.StringWriter;

public class InputStreamToString {

	public void convertStreamToString(InputStream is) {
		
		String theString;
		StringWriter writer = new StringWriter();
	/*	IOUtils.copy(is, writer, "UTF-8");
		String theString = writer.toString();
		
		String myString = IOUtils.toString(myInputStream, "UTF-8");
	*/	
		
		 java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		 
		 theString = s.toString();
		 
	  
	}
}
