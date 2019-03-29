package ua.lpnuai.oop.mokryk03;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TourManager {
	private static ArrayList<Tour> tours = new ArrayList<Tour>();
	private static Scanner s = new Scanner(System.in);
	
	public static void Add() {
		Tour t = new Tour();
		System.out.print("Date: ");
		t.setDate(s.nextLine());
		System.out.print("Time: ");
		t.setTime(s.nextLine());
		System.out.print("Length (min): ");
		t.setLength(Integer.parseInt(s.nextLine()));
		System.out.print("Place: ");
		t.setPlace(s.nextLine());
		System.out.print("Description: ");
		t.setDesc(s.nextLine());
		boolean over = false;
		while(!over) {
			System.out.print("Add person? (y/n): ");
			if(s.nextLine().equals("y")) {
				System.out.print("Person: ");
				t.addPerson(s.nextLine());
			}
			else
				over = true;
		}
		tours.add(t);
	}
	
	public static void Delete() {
		System.out.print("Number of tour to delete: ");
		tours.remove(s.nextInt()-1);
	}
	
	public static void Display() {
		for(Tour i : tours) {
			System.out.println(tours.indexOf(i)+1);
			System.out.println("\tDate: " + i.getDate());
			System.out.println("\tTime: " + i.getTime());
			System.out.println("\tLength: " + i.getLength() + " min");
			System.out.println("\tPlace: " + i.getPlace());
			System.out.println("\tDescription: " + i.getDesc());
			System.out.println("\tPeople:");
			for (String j : i.getPeople())
				System.out.println("\t\t" + j);
		}
	}
	
	public static File SelectFolder() {
		String str = System.getProperty("user.dir");
		File f = new File(str);
		while(true) {
			System.out.println("Path: " + f.getAbsolutePath());
			String arr[] = f.list();
			for(String i : arr) {
				if(new File(i).isFile())
					System.out.print("File: ");
				else
					System.out.print("Folder: ");
				System.out.println(i);
			}
			System.out.print("Change folder? (y/n): ");
			if(s.nextLine().equals("y")) {
				str += "\\" + s.nextLine().trim();
				f = new File(str);
			}
			else {
				str += "\\file.xml";
				f = new File(str);
				break;
			}
		}
		return f;
	}
	
	public static void Save() {
		File f = SelectFolder();
		XMLEncoder encoder;
		try {
			encoder = new XMLEncoder(new FileOutputStream(f.getPath()));
			encoder.writeObject(tours);
			for (Tour i : tours)
				encoder.writeObject(i.getPeople());
			encoder.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
	
	public static void Load() {
		File f = SelectFolder();
		XMLDecoder decoder;
		try {
			decoder = new XMLDecoder(new FileInputStream(f.getPath()));
			tours = (ArrayList<Tour>) decoder.readObject();
			for (Tour i : tours)
				i.setPeople((ArrayList<String>) decoder.readObject());
			decoder.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}