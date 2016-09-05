package src.intermediateProject.allClasses;

import java.util.HashMap;

public class AccountsManagement {

	private HashMap<String, LoggedUser> allAccounts = new HashMap<String, LoggedUser>();
	
	public void addAccountToWebsite(LoggedUser accountToAdd) {
		this.allAccounts.put(accountToAdd.getEmail(), accountToAdd);
		System.out.println("You registered successfully.");
	}

	public void removeAccountFromWebsite(LoggedUser accountToRemove) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	// logging version 1 start
	
	private boolean searchForAccount(String email, String password) {
		if (!(this.allAccounts.containsKey(email))) {
			System.out.println("No account with such email address found.");
			return false;
		}
		//if (!(this.allAccounts.get(email).getPassword().equals(this.allAccounts.get(email).decryptPassword(password)))) {
		if (!(this.allAccounts.get(email).getPassWord().equals(password))) {
			System.out.println("Invalid password.");
			return false;
		}
		return true;
	}
	
	public LoggedUser returnAccount(String email, String password){
		if (!(this.searchForAccount(email, password))) {
			return null;
		}
		return this.allAccounts.get(email);
	}
	
	// logging version 1 end

}
