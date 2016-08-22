package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class EventsManagement {

	private float moneyGainedFromEvents;

	private Map<String, Event> allEventsInCenter = new HashMap<String, Event>();
	private Map<String, Event> eventsWaitingForApproval = new HashMap<String, Event>();

	private boolean searchForEvent(String eventName) {
		if (!(this.allEventsInCenter.containsKey(eventName))) {
			return false;
		}
		return true;
	}

	public void signAccountForEvent(LoggedAccount account, String eventName) {
		if (!(this.searchForEvent(eventName))) {
			System.out.println("No event with such name found.");
			return;
		}
		if (!(this.allEventsInCenter.get(eventName).hasFreePlaces())) {
			System.out.println("No free places for this event left.");
			return;
		}
		this.allEventsInCenter.get(eventName).addParticipant(account);
		this.allEventsInCenter.get(eventName).decreaseFreePlaces();
		account.addEventToParticipateList(this.allEventsInCenter.get(eventName));
	}
	
	public void unsignAccountForEvent(LoggedAccount account, String eventName) {
		if (!(this.searchForEvent(eventName))) {
			System.out.println("No event with such name found.");
			return;
		}
		this.allEventsInCenter.get(eventName).removeParticipant(account);
		this.allEventsInCenter.get(eventName).increaseFreePlaces();
		account.removeEventFromParticipateList(this.allEventsInCenter.get(eventName));
		
	}

	public void addEventToCenter(Event newEvent) {
		if (newEvent == null) {
			System.out.println("Invalid event.");
			return;
		}
		this.allEventsInCenter.put(newEvent.getName(), newEvent);
	}

	public void removeEventFromCenter(Event eventToRemove) {
		if (!(this.searchForEvent(eventToRemove.getName()))) {
			System.out.println("No such event.");
			return;
		}
		this.allEventsInCenter.remove(eventToRemove.getName());
	}

	public void addEventToWaitingForApprovalList(Event newEvent) {
		if (newEvent == null) {
			System.out.println("Invalid event.");
			return;
		}
		this.eventsWaitingForApproval.put(newEvent.getName(), newEvent);
	}

	public void removeEventFromWaitingForApprovalList(Event eventToRemove) {
		if (!(this.searchForEvent(eventToRemove.getName()))) {
			System.out.println("No such event.");
			return;
		}
		this.eventsWaitingForApproval.remove(eventToRemove.getName());
	}

	public void sellPlaceForEvent(LoggedAccount participant, Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
