package ua.lpnuai.oop.mokryk07;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class TourManager {
	private static LinkedList<Tour> tours = new LinkedList<Tour>();
	private static Scanner s = new Scanner(System.in);
	
	public static void add() {
		Tour t = new Tour();
		while (true) {
			System.out.print("Date (dd.MM.yyyy): ");
			String temp = s.nextLine();
			if (PatternMatcher.checkDate(temp))
				t.setDate(temp);
			else {
				System.out.println("Wrong format. Try again.");
				continue;
			}
			System.out.print("Time (hh:mm): ");
			temp = s.nextLine();
			if (PatternMatcher.checkTime(temp))
				t.setTime(temp);
			else {
				System.out.println("Wrong format. Try again.");
				continue;
			}
			System.out.print("Length (min): ");
			temp = s.nextLine();
			if (PatternMatcher.checkLength(temp))
				t.setLength(Integer.parseInt(temp));
			else {
				System.out.println("Wrong format. Try again.");
				continue;
			}
			System.out.print("Place: ");
			t.setPlace(s.nextLine());
			System.out.print("Description: ");
			t.setDesc(s.nextLine());
			while(true) {
				System.out.print("Add person? (y/n): ");
				if(s.nextLine().equals("y")) {
					System.out.print("Person (Name Surname): ");
					temp = s.nextLine();
					if (PatternMatcher.checkPerson(temp))
						t.addPerson(temp);
					else {
						System.out.println("Wrong format. Try again.");
						continue;
					}
				}
				else
					break;
			}
			break;
		}
		tours.add(t);
	}
	
	public static void delete() {
		System.out.print("Number of tour to delete: ");
		tours.remove(s.nextInt()-1);
	}
	
	public static void search() {
		System.out.print("Date to search: ");
		String date = s.nextLine();
		for (Tour i : tours) {
			if (i.getDate().equals(date)) {
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
	}
	
	public static void sort() {
		Collections.sort(tours);
	}
	
	public static void serialize() {
		try {
			FileOutputStream fOutput = new FileOutputStream("file.txt");
			ObjectOutputStream sOutput = new ObjectOutputStream(fOutput);
			sOutput.writeObject(tours);
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
			tours = (LinkedList<Tour>) sInput.readObject();
			sInput.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Object read successfully.");
	}
	
	public static void saveXML() {
		XMLEncoder encoder;
		try {
			encoder = new XMLEncoder(new FileOutputStream("file.xml"));
			encoder.writeObject(tours);
			for (Tour i : tours) {
				encoder.writeObject(i);
				encoder.writeObject(i.getPeople());
				for (String j : i.getPeople())
					encoder.writeObject(j);
			}
			encoder.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		System.out.println("XML saved successfully.");
	}
	
	public static void loadXML() {
		XMLDecoder decoder;
		try {
			decoder = new XMLDecoder(new FileInputStream("file.xml"));
			tours = (LinkedList<Tour>) decoder.readObject();
			Object o = null;
			while (true) {
				try {
					Tour t;
					if (o == null)
						t = (Tour) decoder.readObject();
					else
						t = (Tour) o;
					LinkedList<String> people = (LinkedList<String>) decoder.readObject();
					while (true) {
						try {
							o = decoder.readObject();
							if (o.getClass().equals(String.class)) {
								String s = (String) o;
								people.add(s);
							} else {
								break;
							}
						} catch (Exception e) {
							break;
						}
					}
					t.setPeople(people);
					tours.add(t);
				} catch (Exception e) {
					break;
				}
			}
			decoder.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		System.out.println("XML loaded successfully.");
	}
	
	public static void display() {
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
}