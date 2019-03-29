package ua.lpnuai.oop.mokryk03;

import java.io.Serializable;
import java.util.ArrayList;

public class Tour implements Serializable {
	private int length; // In minutes
	private String date, time, place, desc;
	private ArrayList<String> people = new ArrayList<String>();
	
	public int getLength() { return length; }
	public String getDate() { return date; }
	public String getTime() { return time; }
	public String getPlace() { return place; }
	public String getDesc() { return desc; }
	public ArrayList<String> getPeople() { return people; }
	public void setLength(int length) { this.length = length; }
	public void setDate(String date) {this.date = date; }
	public void setTime(String time) {this.time = time; }
	public void setPlace(String place) { this.place = place; }
	public void setDesc(String desc) { this.desc = desc; }
	public void setPeople(ArrayList<String> people) { this.people = people; }
	public void addPerson(String person) { people.add(person); }
}