package ua.lpnuai.oop.mokryk07;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

public class Tour implements Serializable, Comparable {
	private int length; // In minutes
	private String date, time, place, desc;
	private LinkedList<String> people;
	
	public Tour() {
		people = new LinkedList<String>();
	}
	
	public int getLength() { return length; }
	public String getDate() { return date; }
	public String getTime() { return time; }
	public String getPlace() { return place; }
	public String getDesc() { return desc; }
	public LinkedList<String> getPeople() { return people; }
	public void setLength(int length) { this.length = length; }
	public void setDate(String date) {this.date = date; }
	public void setTime(String time) {this.time = time; }
	public void setPlace(String place) { this.place = place; }
	public void setDesc(String desc) { this.desc = desc; }
	public void setPeople(LinkedList<String> people) { this.people = people; }
	public void addPerson(String person) { people.add(person); }


	@Override
	public int compareTo(Object o) {
		Tour t1 = (Tour) o;
		SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
		Date d1, d2;
		try {
			d1 = f.parse(this.getDate());
			d2 = f.parse(t1.getDate());
			return d1.compareTo(d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}}