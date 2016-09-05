package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class GuestUser extends User{

	public GuestUser(WebsiteSystem system) {
		super(system);
		// TODO Auto-generated constructor stub
	}

	public void login(String email, String password) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	// login version 1 start
	
	public void login1(String email, String password) {
		if (this.getSystem().getAccountsManagement().returnAccount(email, password) == null) {
			System.out.println("Login denied.");
		} else {
			System.out.println("Login successfull.");
			this.setAmILoggedIn(this.getSystem().getAccountsManagement().returnAccount(email, password)); 
		}
	}
	
	// login version 1 end

	public void register() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public boolean register1(String firstName, String lastName, String username, String email, String address, String phoneNumber, String password) {
		LoggedUser registerUser = new LoggedUser(firstName, lastName, username, email, address, phoneNumber, password);
		this.getSystem().getAccountsManagement().addAccountToWebsite(registerUser);
		return true;
	}

}
