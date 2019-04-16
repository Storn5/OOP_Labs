package ua.lpnuai.oop.mokryk05;

import java.io.Serializable;

public class Tour implements Serializable {
	private int length; // In minutes
	private String date, time, place, desc;
	private GenericLinkedList<String> people;
	
	public Tour() {
		people = new GenericLinkedList<String>();
	}
	
	public int getLength() { return length; }
	public String getDate() { return date; }
	public String getTime() { return time; }
	public String getPlace() { return place; }
	public String getDesc() { return desc; }
	public GenericLinkedList<String> getPeople() { return people; }
	public void setLength(int length) { this.length = length; }
	public void setDate(String date) {this.date = date; }
	public void setTime(String time) {this.time = time; }
	public void setPlace(String place) { this.place = place; }
	public void setDesc(String desc) { this.desc = desc; }
	public void setPeople(GenericLinkedList<String> people) { this.people = people; }
	public void addPerson(String person) { people.insert(person); }
}