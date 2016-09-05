package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class EventsManagement {

	private float moneyGainedFromEvents;

	private Map<Long, Event> allEventsInCenter = new HashMap<Long, Event>();
	private Map<Long, Event> eventsWaitingForApproval = new HashMap<Long, Event>();

	static class Period {
		long eventId;
		Date beginning;
		Date ending;
	}
	
	static class SortPeriodsByDateComparator implements Comparator<Period> {

		@Override
		public int compare(Period o1, Period o2) {
			// TODO Auto-generated method stub
			return 0;
		}	
	}
	
	private List<Period> occupiedPeriods = new LinkedList<Period>();
	
	private boolean searchForEvent(Long eventId) {
		if (!(this.allEventsInCenter.containsKey(eventId))) {
			return false;
		}
		return true;
	}

	public void signAccountForEvent(LoggedUser account, Long eventId) {
		if (!(this.searchForEvent(eventId))) {
			System.out.println("\nNo event with such id found.");
			return;
		}
		if (!(this.allEventsInCenter.get(eventId).hasFreePlaces())) {
			System.out.println("\nNo free places for this event left.");
			return;
		}
		this.allEventsInCenter.get(eventId).addParticipant(account);
		this.allEventsInCenter.get(eventId).decreaseFreePlaces();
		account.addEventToParticipateList(this.allEventsInCenter.get(eventId));
		System.out.println("\nYou signed for event successfully!");
	}
	
	public void unsignAccountForEvent(LoggedUser account, Long eventId) {
		if (!(this.searchForEvent(eventId))) {
			System.out.println("\nNo event with such name found.");
			return;
		}
		this.allEventsInCenter.get(eventId).removeParticipant(account);
		this.allEventsInCenter.get(eventId).increaseFreePlaces();
		account.removeEventFromParticipateList(this.allEventsInCenter.get(eventId));
		
	}

	public void addEventToCenter(Event event) {
		this.occupiedPeriods.add(new Period());
		this.occupiedPeriods.sort(new SortPeriodsByDateComparator());
		this.allEventsInCenter.put(event.getId(), event);
	}

	public void removeEventFromCenter(Event eventToRemove) {
		if (!(this.searchForEvent(eventToRemove.getId()))) {
			System.out.println("No such event.");
			return;
		}
		this.allEventsInCenter.remove(eventToRemove.getName());
	}

	public void addEventToWaitingForApprovalList(Event event) {
		boolean eventAdded = false;
		if (event == null) {
			System.out.println("Invalid event.");
			return;
		}
		for (int index = 1; index < this.occupiedPeriods.size(); index++) {
			boolean isNewBeginningAfterPreviousEnding = event.getBeginning().compareTo(this.occupiedPeriods.get(index - 1).ending) >=0;
			boolean isNewEndingBeforeNextBeginning = event.getBeginning().compareTo(this.occupiedPeriods.get(index - 1).ending) >=0;
			if (isNewBeginningAfterPreviousEnding && isNewEndingBeforeNextBeginning) {
				
				this.eventsWaitingForApproval.put(event.getId(), event);
			} else {
				System.out.println("Cannot add event. Time you request is occupied.");
			}
		}
		
		
	}

	public void removeEventFromWaitingForApprovalList(Event eventToRemove) {
		if (!(this.searchForEvent(eventToRemove.getId()))) {
			System.out.println("No such event.");
			return;
		}
		this.eventsWaitingForApproval.remove(eventToRemove.getId());
	}

	public void sellPlaceForEvent(LoggedUser participant, Event event) {
		this.moneyGainedFromEvents += event.getPrice();
		participant.payForEvent(event);
	}

}
