package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class GuestAccount extends User{

	public void login(String email, String password) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	// login version 1 start
	
	public void loginVersion1(String email, String password) {
		if (this.system.getAccountsManagement().returnAccount(email, password) == null) {
			System.out.println("Login denied.");
		} else {
			this.amILoggedIn = this.system.getAccountsManagement().returnAccount(email, password);
		}
	}
	
	// login version 1 end

	public void register() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
