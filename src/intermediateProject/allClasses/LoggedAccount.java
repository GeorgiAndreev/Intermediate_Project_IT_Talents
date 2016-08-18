package intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class LoggedAccount {

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private Cart cart;
	private HashSet<Event> eventsIParticipateIn;
	private HashSet<Event> eventsITeachIn;
	private HashSet<Product> productsISell;
	private float money;
	private String phoneNumber;

	public void logout() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeAccount() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void changePassword(String newPassword) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void changeEmail(String newEmail) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void signForEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void unsignFromEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public Event createEvent(String name, String description, int capacity, float price) {
		return new Event(name, description, capacity, price);
	}

	public void removeEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void pay() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void addItemForSale(Product product) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeItemForSale(Product product) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
