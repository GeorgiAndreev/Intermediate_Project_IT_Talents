package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class MultidayEvent extends Event{

	private TreeSet<Event> eventSchedule;
	
	public MultidayEvent(String name, String description, int capacity, float price) {
		super(name, description, capacity, price);
	}

	public void addEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
