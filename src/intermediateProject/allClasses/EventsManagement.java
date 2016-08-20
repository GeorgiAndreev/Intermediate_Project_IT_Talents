package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class EventsManagement {
	
	private float moneyGainedFromEvents;

	private Map<String, Event> allEventsInCenter = new HashMap<String, Event>();
	private Map<String, Event> eventsWaitingForApproval = new HashMap<String, Event>();

	public void addEventToCenter(Event newEvent) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeEventFromCenter(Event eventToRemove) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	public void addEventToWaitingForApprovalList(Event newEvent) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeEventFromWaitingForApprovalList(Event eventToRemove) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	public void sellPlaceForEvent(LoggedAccount participant, Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
