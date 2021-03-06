package src.intermediateProject.allClasses;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import src.intermediateProject.allExceptions.EventsException;
import src.intermediateProject.allExceptions.PartOfEventException;

public class Event {
	
	private long id;
	private static long nextId;
	private String name;
	private String teachersNames;
	private String description;
	private int freeSpaces;
	private int capacity;
	private float price;
	private SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	private SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date beginning;
	private Date ending;
	private Set<PartOfEvent> eventParts = new TreeSet<PartOfEvent>();
	private Set<LoggedUser> teachers = new HashSet<LoggedUser>();
	private Set<LoggedUser> participants = new HashSet<LoggedUser>();
	private LoggedUser eventCreator;
	
	public Event(String name, String description, int capacity, float price, Date beginning, Date ending, LoggedUser eventCreator) throws EventsException {
		if ((name != null) && (!name.equals(""))) {
			this.name = name;
		} else {
			throw new EventsException("Invalid name input.");
		}
		if ((description != null) && (!description.equals(""))) {
			this.description = description;
		} else {
			throw new EventsException("Invalid description input.");
		}
		if (capacity > 0) {
			this.capacity = capacity;
		} else {
			throw new EventsException("Invalid capacity input.");
		}
		this.freeSpaces = capacity;
		if (price >= 0) {
			this.price = price;
		} else {
			throw new EventsException("Invalid price input.");
		}
		Date now = new Date();
		if ((beginning != null) && (!beginning.equals("")) && (beginning.compareTo(ending) < 0) && beginning.compareTo(now) > 0) {
			this.beginning = beginning;
		} else {
			throw new EventsException("Invalid beginning input.");
		}
		if ((ending != null) && (!ending.equals(""))) {
			this.ending = ending;
		} else {
			throw new EventsException("Invalid ending input.");
		}
		if (eventCreator != null) {
			this.eventCreator = eventCreator;
		} else {
			throw new EventsException("Invalid teacher input.");
		}
		this.id = Event.nextId++;
	}
	
	public Event(String name, String description, int capacity, float price, String beginningDate, String endingDate, LoggedUser eventCreator) throws EventsException, ParseException {
		if ((name != null) && (!name.equals(""))) {
			this.name = name;
		} else {
			throw new EventsException("Invalid name input.");
		}
		if ((description != null) && (!description.equals(""))) {
			this.description = description;
		} else {
			throw new EventsException("Invalid description input.");
		}
		if (capacity > 0) {
			this.capacity = capacity;
		} else {
			throw new EventsException("Invalid capacity input.");
		}
		this.freeSpaces = capacity;
		if (price >= 0) {
			this.price = price;
		} else {
			throw new EventsException("Invalid price input.");
		}
		Date now = new Date();
		Date beginning = dateFormat1.parse(beginningDate);
		Date ending = dateFormat1.parse(endingDate);
		if ((beginning != null) && (!beginning.equals("")) && (beginning.compareTo(ending) < 0) && beginning.compareTo(now) > 0) {
			this.beginning = beginning;
		} else {
			throw new EventsException("Invalid beginning input.");
		}
		if ((ending != null) && (!ending.equals(""))) {
			this.ending = ending;
		} else {
			throw new EventsException("Invalid ending input.");
		}
		if (eventCreator != null) {
			this.eventCreator = eventCreator;
		} else {
			throw new EventsException("Invalid teacher input.");
		}
		this.id = Event.nextId++;
	}

	public Event(String name, String description, int capacity, float price) throws EventsException {
		if ((name != null) && (!name.equals(""))) {
			this.name = name;
		} else {
			throw new EventsException("Invalid name input.");
		}
		if ((description != null) && (!description.equals(""))) {
			this.description = description;
		} else {
			throw new EventsException("Invalid description input.");
		}
		if (capacity > 0) {
			this.capacity = capacity;
		} else {
			throw new EventsException("Invalid capacity input.");
		}
		this.freeSpaces = capacity;
		if (price >= 0) {
			this.price = price;
		} else {
			throw new EventsException("Invalid price input.");
		}
		this.id = Event.nextId++;
	}

	public void addPartOfEvent(String name, String description, Date beginning, Date ending) throws PartOfEventException {
		if ((name == null) || (name.equals(""))) {
			System.out.println("Invalid name input.");
			return;
		}
		if ((description == null) || (description.equals(""))) {
			System.out.println("Invalid description input.");
			return;
		}
		if (beginning.compareTo(ending) >= 0) {
			System.out.println("Invalid beginning or endeng input.");
			return;
		}
		if ((beginning == null) || (beginning.equals("")) || (beginning.compareTo(this.beginning) < 0)) {
			System.out.println("Invalid beginning input.");
			return;
		}
		if ((ending == null) || (ending.equals("")) || (ending.compareTo(this.ending) > 0)) {
			System.out.println("Invalid ending input.");
			return;
		}
		this.eventParts.add(new PartOfEvent(name, description, beginning, ending));
	}

	public class PartOfEvent implements Comparable<PartOfEvent> {

		private String name;
		private String description;
		private Date beginning;
		private Date ending;
		

		public PartOfEvent(String name, String description, Date beginning, Date ending) throws PartOfEventException {
			if ((name != null) && (!name.equals(""))) {
				this.name = name;
			} else {
				throw new PartOfEventException("Invalid name input.");
			}
			if ((description != null) && (!description.equals(""))) {
				this.description = description;
			} else {
				throw new PartOfEventException("Invalid description input.");
			}
			if (beginning.compareTo(ending) >= 0) {
				throw new PartOfEventException("Invalid beginning or ending date.");
			}
			if ((beginning != null) && (!beginning.equals("")) && (beginning.compareTo(Event.this.beginning) >= 0)) {
				this.beginning = beginning;
			} else {
				throw new PartOfEventException("Invalid date for beginning.");
			}
			if ((ending != null) && (!ending.equals("")) && (ending.compareTo(Event.this.ending) < 0)) {
				this.ending = ending;
			} else {
				throw new PartOfEventException("Invalid date for ending.");
			} 
		}

		@Override
		public int compareTo(PartOfEvent anotherPart) {
			return this.ending.compareTo(anotherPart.beginning);
		}
	}

	@Override
	public String toString() {
		return "\nEvent \nname = " + name + ", \ndescription = " + description + ", \nfreeSpaces = " + freeSpaces
				+ ", \ncapacity = " + capacity + ", \nprice = " + price;
	}

	public void increaseFreePlaces() {
		if (this.freeSpaces < this.capacity) {
			this.freeSpaces += 1;
		} else {
			System.out.println("Cannot increase free spaces. Maximum capacity ( " + this.capacity + " ) reached.");
		}
	}
	
	public void decreaseFreePlaces() {
		if (this.freeSpaces > 0) {
			this.freeSpaces -= 1;
		} else {
			System.out.println("No more free spaces.");
		}
	}
	
	public boolean hasFreePlaces() {
		if (this.freeSpaces <= this.capacity) {
			return true;
		}
		return false;
	}
	
	public boolean hasParts() {
		if (this.eventParts.isEmpty()) {
			return false;
		}
		return true;
	}

	public void addTeacher(LoggedUser teacher) throws EventsException {
		if (teacher == null) {
			System.out.println("Invalid teacher input.");
			return;
		}
		if (this.teachers.contains(teacher)) {

		}
		this.teachers.add(teacher);
	}

	public void removeTeacher(LoggedUser teacher) {
		if (teacher == null) {
			System.out.println("Invalid teacher input.");
			return;
		}
		this.teachers.remove(teacher);
	}

	public void addParticipant(LoggedUser participant) {
		if (participant == null) {
			System.out.println("Invalid participant input.");
			return;
		}
		if (this.participants.contains(participant)) {

		}
		this.participants.add(participant);
	}

	public void removeParticipant(LoggedUser participant) {
		if (participant == null) {
			System.out.println("Invalid participant input.");
			return;
		}
		this.participants.remove(participant);
	}

	public Date getBeginning() {
		return beginning;
	}

	// public void setBeginning(Date beginning) {
	// this.beginning = beginning;
	// }

	public Date getEnding() {
		return ending;
	}

	// public void setEnding(Date ending) {
	// this.ending = ending;
	// }
	
	public String getName() {
		return name;
	}
	
	public float getPrice() {
		return price;
	}

	public long getId() {
		return id;
	}

}
