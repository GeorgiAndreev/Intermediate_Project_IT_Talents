package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

import src.intermediateProject.allExceptions.CartException;
import src.intermediateProject.allExceptions.EventsException;
import src.intermediateProject.allExceptions.ProductException;
import src.intermediateProject.allExceptions.UserException;

public class LoggedAccount extends User {

	private String username;
	private String encryptedPassword;
	private Password password = new Password();
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private Cart cart;
	private Set<Event> eventsIParticipateIn = new HashSet<Event>();
	private Set<Event> eventsITeachIn = new HashSet<Event>();
	private Shop shop;
	private float money;
	private String phoneNumber;

	public LoggedAccount(String password) {
		this.encryptedPassword = this.password.encryptPassword(password);
	}

	public LoggedAccount(String username, Shop shop, float money) {
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
		this.amILoggedIn = null;
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

	public void signForEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void unsignFromEvent(Event event) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public Event createEvent(String name, String description, int capacity, float price, String type)
			throws EventsException {
		if (type.equals("single")) {
			return new Event(name, description, capacity, price);
		}
		if (type.equals("multiple")) {
			return new MultidayEvent(name, description, capacity, price);
		}
		return null;
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

}
