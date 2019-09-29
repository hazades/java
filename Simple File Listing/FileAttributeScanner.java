import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.security.MessageDigest;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FAS {

	public static void main(String[] args) throws Exception {
		File f = new File("D:\\Documents\\fas.xls");
		//change storage path yourself above
		WritableWorkbook myexcel = Workbook.createWorkbook(f);
		WritableSheet mysheet = myexcel.createSheet("mysheet", 0);

		try {

			Scanner input = new Scanner(System.in);
			int n = 1;
			int c = 0;
			// get user to input the path of file

			System.out.print("Enter file path: ");
			String path = input.nextLine();

			File dir = new File(path); // Escape sequence needed for '\'

			if (dir.isDirectory()) {
				File[] items = dir.listFiles();

				for (int i = 0; i < items.length; i++) {
					File item = items[i];
					System.out.println(n + ": " + item.getAbsoluteFile());
					String fullpath = (n + ": " + item.getAbsoluteFile()).toString();

					Label label = new Label(0, c, "Fullpath :");
					mysheet.addCell(label);
					label = new Label(2, c, fullpath);
					mysheet.addCell(label);
					c++;

					// get the file name
					System.out.println("File Name: " + item.getName());
					String fn = item.getName();
					Label label1 = new Label(0, c, "Filename :");
					mysheet.addCell(label1);
					label1 = new Label(2, c, fn);
					mysheet.addCell(label1);
					c++;

					// get the file location or directory

					System.out.println("File path: " + item.getAbsolutePath());
					String fp = item.getAbsolutePath();
					Label label2 = new Label(0, c, "Filepath :");
					mysheet.addCell(label2);
					label2 = new Label(2, c, fp);
					mysheet.addCell(label2);
					c++;

					// get the size of the file in kb

					System.out.println("The size in kb is: " + getFileSizeKiloBytes(item));
					String s = getFileSizeKiloBytes(item);
					Label label3 = new Label(0, c, "Size :");
					mysheet.addCell(label3);
					label3 = new Label(2, c, s);
					mysheet.addCell(label3);
					c++;

					// get the owner name
					Path pathh = Paths.get(path);
					FileStore fs = Files.getFileStore(pathh);

					UserPrincipal owner = Files.getOwner(pathh);
					String username = owner.getName();
					System.out.println("Owner is: " + username);
					// String ow = item.getName();
					Label label4 = new Label(0, c, "Username :");
					mysheet.addCell(label4);
					label4 = new Label(2, c, username);
					mysheet.addCell(label4);
					c++;

					// get the date created

					BasicFileAttributes attr = Files.readAttributes(pathh, BasicFileAttributes.class);
					System.out.println("Creation Time: " + attr.creationTime());
					FileTime fdc = attr.creationTime();
					// String dc = ft.toString();
					Label label5 = new Label(0, c, "Creation Time :");
					mysheet.addCell(label5);
					label5 = new Label(2, c, fdc.toString());
					mysheet.addCell(label5);
					c++;

					// get the time last access

					System.out.println("Last Access Time: " + attr.lastAccessTime());
					FileTime fla = attr.creationTime();
					// String lc = item.getName();
					Label label6 = new Label(0, c, "Last Access :");
					mysheet.addCell(label6);
					label6 = new Label(2, c, fla.toString());
					mysheet.addCell(label6);
					c++;

					// get the date modified

					System.out.println("Last Modified Time: " + attr.lastModifiedTime());
					FileTime fdm = attr.lastModifiedTime();
					// String dm = item.getName();
					Label label7 = new Label(0, c, "Last Modified :");
					mysheet.addCell(label7);
					label7 = new Label(2, c, fdm.toString());
					mysheet.addCell(label7);
					c++;

					// read only(yes/no)
					Label label8 = new Label(0, c, "Read/Write :");
					mysheet.addCell(label8);

					if (item.canRead() == true && item.canWrite() == false) {
						System.out.println("Read Only");
						// String ro = item.getName();
						label8 = new Label(2, c, "Read Only");
						mysheet.addCell(label8);
						c++;

					} else if (item.canWrite() == true && item.canRead() == false) {
						System.out.println("Write Only");
						// String wo = item.getName();
						label8 = new Label(2, c, "Write Only");
						mysheet.addCell(label8);
						c++;

					} else if (item.canRead() == true && item.canWrite() == true) {
						System.out.println("Read & Write");
						// String rw = item.getName();
						label8 = new Label(2, c, "Read & Write");
						mysheet.addCell(label8);
						c++;

					} else {
						System.out.println("No File");
						// String nf = item.getName();
						label8 = new Label(2, c, "No File");
						mysheet.addCell(label8);
						c++;
					}

					// hidden(yes/no)
					Label label9 = new Label(0, c, "Hidden/Un-Hidden :");
					mysheet.addCell(label9);

					if (item.isHidden()) {
						System.out.println("This file " + item.getName() + " is hidden");
						String h = item.getName() + " is hidden";
						label9 = new Label(2, c, h);
						mysheet.addCell(label9);
						c++;

					} else {
						System.out.println("This file " + item.getName() + " is not hidden");
						String uh = item.getName() + " is not hidden";
						label9 = new Label(2, c, uh);
						mysheet.addCell(label9);
						c++;

					}

					// Hash value(md5/sha1/sha256)

					FileReader file = new FileReader(item.getAbsolutePath());
					BufferedReader in = new BufferedReader(file);
					String str = "";
					while (in.readLine() != null) {
						str += in.readLine();
					}
					System.out.println("MD5: " + getMD5(str).toUpperCase());
					// String md = item.getName();
					Label label10 = new Label(0, c, "MD-5 :");
					mysheet.addCell(label10);
					label10 = new Label(2, c, getMD5(str).toUpperCase());
					mysheet.addCell(label10);
					c++;

					System.out.println("SHA-1: " + convertToHex(encrypt(str)).toUpperCase());
					// String sh1 = item.getName();
					Label label11 = new Label(0, c, "SHA-1 :");
					mysheet.addCell(label11);
					label11 = new Label(2, c, convertToHex(encrypt(str)).toUpperCase());
					mysheet.addCell(label11);
					c++;

					System.out.println("SHA-256: " + convertToHex(encrypt256(str)).toUpperCase());
					// String sh256 = item.getName();
					Label label12 = new Label(0, c, "SHA-256 :");
					mysheet.addCell(label12);
					label12 = new Label(2, c, convertToHex(encrypt256(str)).toUpperCase());
					mysheet.addCell(label12);
					c++;

					n++;
					c++;// bg gap antre file

					System.out.println();
					System.out.println();
				}
			}
		} catch (

		Exception e)

		{
		}
		myexcel.write();
		myexcel.close();
	}

	// get file size method

	private static String getFileSizeKiloBytes(File item) {
		return (double) item.length() / 1024 + "  kb";
	}

	// method sha1 encryption
	public static byte[] encrypt(String x) throws Exception {
		java.security.MessageDigest d = null;

		d = java.security.MessageDigest.getInstance("SHA-1");
		d.reset();
		d.update(x.getBytes("UTF-8"));
		return d.digest();
	}

	// method sha256 encryption
	public static byte[] encrypt256(String y) throws Exception {
		java.security.MessageDigest ds = null;

		ds = java.security.MessageDigest.getInstance("SHA-256");
		ds.reset();
		ds.update(y.getBytes("UTF-8"));
		return ds.digest();
	}

	// method md5 encryption
	public static String getMD5(String s) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md.digest(s.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	// method convert the byte value into hexadecimal value
	public static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;

			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

}
