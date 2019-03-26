package ua.lpnuai.oop.mokryk02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class StringManager {
	public static StringIterator si = new StringIterator();
	public static StringBuilder sb;
	public static int k;
	public static char c;
	
	public static void addStr(Scanner s) {
		System.out.print("Enter string to add: ");
		si.add(s.nextLine());
	}
	public static void getNumAndChar(Scanner s) {
		System.out.print("Enter the number k and the letter to replace: ");
		String temp[] = s.nextLine().split(" ");
		if (Main.debug)
			System.out.println("k: " + temp[0] + "\nc: " + temp[1]);
		k = Integer.parseInt(temp[0]);
		c = temp[1].charAt(0);
		if (k > ((String) si.toArray()[0]).length()) {
			System.out.println("Error: k is bigger than the string");
			Menu.quit();
		}
	}
	public static void deleteStr(Scanner s) {
		System.out.print("Enter string to delete: ");
		String str = s.nextLine().trim();
		if (si.contains(str))
			si.remove(str);
		else
			System.out.println("String not found.");
	}
	public static void serialize() {
		try {
			FileOutputStream fOutput = new FileOutputStream("file.txt");
			ObjectOutputStream sOutput = new ObjectOutputStream(fOutput);
			sOutput.writeObject(si);
			sOutput.flush();
			sOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Object written successfully.");
	}
	public static void deSerialize() {
		try {
			FileInputStream fInput = new FileInputStream("file.txt");
			ObjectInputStream sInput = new ObjectInputStream(fInput);
			si = (StringIterator) sInput.readObject();
			sInput.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Object read successfully.");
	}
	public static void printTable() {
		sb = new StringBuilder();
		Iterator<String> iter = si.iterator();
		while(iter.hasNext()) {
			String iterStr = iter.next();
			for (int i = 0; i < ((String) iterStr).length(); i ++) {
				if ((i+1) % k != 0 || i == 0)
					sb.append(((String) iterStr).charAt(i));
				else
					sb.append(c);
				if (Main.debug)
					System.out.println(sb);
			}
			System.out.println(iterStr);
			System.out.println(sb.toString());
			sb = new StringBuilder();
		}
	}
}
