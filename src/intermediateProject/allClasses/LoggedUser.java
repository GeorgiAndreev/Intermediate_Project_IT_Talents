package src.intermediateProject.allClasses;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import src.intermediateProject.allExceptions.CartException;
import src.intermediateProject.allExceptions.EventsException;
import src.intermediateProject.allExceptions.ProductException;
import src.intermediateProject.allExceptions.UserException;

public class LoggedUser extends User {
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String address;
	private String phoneNumber;
	private String passWord;
	private String encryptedPassword;
	private Password password = new Password();
	private Cart cart;
	private Set<Event> eventsIParticipateIn = new HashSet<Event>();
	private Set<Event> eventsITeachIn = new HashSet<Event>();
	private Shop shop;
	private float money;
	
	
	public LoggedUser(String firstName, String lastName, String username, String email, String address,
			String phoneNumber, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.passWord = passWord;
	}

	public LoggedUser(String email, String passWord) {
		super();
		this.email = email;
		this.passWord = passWord;
	}

	public LoggedUser(WebsiteSystem system) {
		super(system);
		// TODO Auto-generated constructor stub
	}

	public LoggedUser(String password, WebsiteSystem website) {
		this(website);
		this.encryptedPassword = this.password.encryptPassword(password);
		this.money = 1000;
	}

	public LoggedUser(String username, Shop shop, float money) {
		this.username = username;
		this.cart = new Cart();
		this.shop = shop;
		this.money = money;
	}

	private class Password {

		String encryptPassword(String password) {
			StringBuilder sb1 = new StringBuilder("Domat");
			StringBuilder sb2 = new StringBuilder(password);
			StringBuilder sb3 = new StringBuilder("4u6ka");
			sb2.reverse();
			sb1.append(sb2);
			sb1.append(sb3);
			String encryptedPassword = sb1.toString();
			return encryptedPassword;
		}

		String decryptPassword(String encryptedPassword) {
			StringBuilder sb1 = new StringBuilder(encryptedPassword);
			sb1.reverse();
			String password = sb1.substring(5, encryptedPassword.length() - 10);
			return password;
		}
	}

	protected String decryptPassword(String encryptedPassword) {
		return this.password.decryptPassword(encryptedPassword);
	}
	
	public void logout() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	// logging version 1 start

	public void logoutVersion1() {
		setAmILoggedIn(null);;
	}

	// password 6te e vutre6en klas i tuk 6te se vru6ta kriptirana parola
	public String getPassword() {
		return encryptedPassword;
	}

	// logging version 1 end

	public void removeAccount() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void changePassword(String newPassword) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void changeEmail(String newEmail) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	/*public void signForEvent(Event event) {
		if ((event != null) && this.system.getEventsManagement().) {
			
		}
	}

	public void unsignFromEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}*/
	
	public void addEventToParticipateList(Event event) {
		this.eventsIParticipateIn.add(event);
	}
	
	public void removeEventFromParticipateList(Event event) {
		this.eventsIParticipateIn.remove(event);
	}
	
	public void signForEvent(Long eventId) {
		if ((eventId > 0) && (this.getSystem().getEventsManagement()!= null)) {
			this.getSystem().getEventsManagement().signAccountForEvent(this, eventId);
		}
 	}

	public void unsignFromEvent(Long eventId) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	public void payForEvent(Event event) {
		if (this.money >= event.getPrice()) {
			this.money -= event.getPrice();
		}
	}

	public Event createEvent(String name, String description, int capacity, float price, String beginningDate, String endingDate, int numberOfSubevents)
			throws EventsException, ParseException {
		Event event = new Event(name, description, capacity, price, beginningDate, endingDate, this);
		//Event event = new Event(name, description, capacity, price);
		String subeventName = null;
		String subeventDescription = null;
		String subeventBeginningString = null;
		String subeventEndingString = null;
		Date subeventBeginning = null;
		Date subeventEnding = null;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		for (int subevent = 1; subevent <= numberOfSubevents; subevent++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Insert part ¹ " + subevent + " name: ");
			subeventName = sc.nextLine();
			System.out.println("Insert part ¹ " + subevent + " description: ");
			subeventDescription = sc.nextLine();
			System.out.println("Insert part ¹ " + subevent + " beginning: ");
			subeventBeginningString = sc.nextLine();
			System.out.println("Insert part ¹ " + subevent + " ending: ");
			subeventEndingString = sc.nextLine();			
			//event.addSubevent(new Event(subeventName,subeventDescription,subeventCapacity,subeventPrice));
			event.addPartOfEvent(subeventName, subeventDescription, dateFormat1.parse(subeventBeginningString), dateFormat1.parse(subeventEndingString));
			sc.close();
		}
		
		return event;
	}
	
	public void addEventToWebsite(Event event) {
		this.getSystem().getEventsManagement().addEventToWaitingForApprovalList(event);
	}

	public void removeEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void pay() throws UserException {
		if (cart.getMoneyToPay() < this.money) {
			for (Product product : cart.getProducts()) {
				float price = product.getPrice() * product.getQuantity();
				product.getSeller().sellProduct(price);
				this.money -= price;
			}
			cart.getProducts().removeAll(cart.getProducts());
		} else {
			throw new UserException("Not enough money to buy all items!");
		}
	}

	public void sellProduct(float moneyFromProdoct) throws UserException {
		if (money > 0) {
			this.money += moneyFromProdoct;
		} else {
			throw new UserException("Cant sell a product that is not yours!");
		}
	}

	public void addToCart(Product productFromShop, int quantity) throws ProductException, CartException, UserException {
		if (this.shop.hasProduct(productFromShop) && productFromShop != null) {
			if (productFromShop.getQuantity() > quantity) {
				cart.addToCart(productFromShop, quantity);
				productFromShop.decreaseQuantity(quantity);
			} else {
				throw new UserException("Desired quantity must be lower then that presented in shop!");
			}
		}
	}

	public void removeFromCart(Product productFromCart, int quantity)
			throws ProductException, CartException, UserException {
		if (this.cart.getProduct(productFromCart) != null && productFromCart != null) {
			if (productFromCart.getQuantity() > quantity) {
				cart.removeFromCart(productFromCart, quantity);
				productFromCart.increaseQuantity(quantity);
			} else {
				throw new UserException("Desired quantity must be lower then that presented in shop!");
			}
		}
	}

	public Cart getCart() {
		return cart;
	}

	@Override
	public String toString() {
		return "LoggedAccount [username=" + username + ", money=" + money + "]";
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassWord() {
		return passWord;
	}

}
