package indexing;

import java.io.BufferedReader;
import java.io.FileReader;

public class call_testing {
	
	public call_testing (String test) throws Exception{
		FileReader in = new FileReader(test);
	    BufferedReader br = new BufferedReader(in);
	    String line = br.readLine();
	    while (line!=null) {
	        System.out.println(line);
	        line = br.readLine();
	    }
	    in.close();
	}
}
