package indexing;

import java.io.BufferedReader;
import java.io.FileReader;

public class call_pattern {
	
	
	public call_pattern (String training) throws Exception{
		FileReader in = new FileReader(training);
	    BufferedReader br = new BufferedReader(in);
	    String line = br.readLine();
	    while (line!=null) {
	    	Binary bin = new Binary(line);
	        System.out.println(line);
	        line = br.readLine();
	        
	    }
	    in.close();
	}
}
