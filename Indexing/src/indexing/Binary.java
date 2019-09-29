package indexing;

public class Binary {

	public Binary(String str) {

	    String result = "";
	    char[] messChar = str.toCharArray();

	    for (int i = 0; i < messChar.length; i++) {
	        result += Integer.toBinaryString(messChar[i]) + " ";
	    }

	    System.out.println(result);
	}
}
