package intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class Event {

	private String name;
	private String description;
	private int freeSpaces;
	private int capacity;
	private float price;
	private HashSet<LoggedAccount> teachers;
	private HashSet<LoggedAccount> participants;

	public Event(String name, String description, int capacity, float price) {
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.freeSpaces = capacity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "\nEvent \nname = " + name + ", \ndescription = " + description + ", \nfreeSpaces = " + freeSpaces + ", \ncapacity = "
				+ capacity + ", \nprice = " + price;
	}

	public void addTeacher(LoggedAccount teacher) {
		this.teachers.add(teacher);
	}

	public void removeTeacher(LoggedAccount teacher) {
		this.teachers.remove(teacher);
	}

	public void addParticipant(LoggedAccount participant) {
		this.participants.add(participant);
	}

	public void removeParticipant(LoggedAccount participant) {
		this.participants.remove(participant);
	}

}
