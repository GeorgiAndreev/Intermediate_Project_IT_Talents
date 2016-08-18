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
		return "Event [name=" + name + ", description=" + description + ", freeSpaces=" + freeSpaces + ", capacity="
				+ capacity + ", price=" + price + "]";
	}

	public void addTeacher(LoggedAccount teacher) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeTeacher(LoggedAccount teacher) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void addParticipant(LoggedAccount participant) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeParticipant(LoggedAccount participant) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
