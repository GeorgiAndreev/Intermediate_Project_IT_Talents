package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

import src.intermediateProject.allExceptions.EventsException;

public class MultidayEvent extends Event{

	private SortedSet<Event> eventSchedule = new TreeSet<Event>();
	
	public MultidayEvent(String name, String description, int capacity, float price) throws EventsException {
		super(name, description, capacity, price);
		long id = super.getNextId();
		this.setId(id);
		super.setId(id + 1);
	}

	public void addEvent(Event event) {
		this.eventSchedule.add(event);
	}

	public void removeEvent(Event event) {
		this.eventSchedule.remove(event);
	}

}
