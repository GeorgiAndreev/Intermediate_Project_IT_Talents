package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

import src.intermediateProject.allExceptions.EventsException;

public class MultidayEvent extends Event{

	private SortedSet<Event> eventSchedule = new TreeSet<Event>();
	
	public MultidayEvent(String name, String description, int capacity, float price) throws EventsException {
		super(name, description, capacity, price);
	}

	public void addEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
