package src.intermediateProject.allClasses;

import java.util.HashMap;

public class AccountsManagement {

	private HashMap<String, LoggedAccount> allAccounts;
	
	public void addAccountToWebsite(LoggedAccount accountToAdd) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void removeAccountFromWebsite(LoggedAccount accountToRemove) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}
	
	// logging version 1 start
	
	private boolean searchForAccount(String email, String password) {
		if (!(this.allAccounts.containsKey(email))) {
			System.out.println("No account with such email address found.");
			return false;
		}
		if (!(this.allAccounts.get(email).getPassword().equals(this.allAccounts.get(email).decryptPassword(password)))) {
			System.out.println("Invalid password.");
			return false;
		}
		return true;
	}
	
	public LoggedAccount returnAccount(String email, String password){
		if (!(this.searchForAccount(email, password))) {
			return null;
		}
		return this.allAccounts.get(email);
	}
	
	// logging version 1 end

}
