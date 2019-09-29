import java.io.File;
import java.util.Scanner;

public class ListFile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file path: ");
		String path = input.nextLine();

		File dir = new File(path); // Escape sequence needed for '\'
		//listRecursive(dir);
		//F:\Sem 6\ISA
		
		if (dir.isDirectory()) {
			File[] items = dir.listFiles();
			
			//for (File item : items) {
			for(int i=0;i<items.length;i++){
				File item = items[i];
				System.out.println(item.getAbsoluteFile());
			}
		}
	}

}