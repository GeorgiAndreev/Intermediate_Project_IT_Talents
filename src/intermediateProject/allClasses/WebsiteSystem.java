package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

public class WebsiteSystem {

	private AccountsManagement accountsManagement; 
	private Shop shop;
	private EventsManagement eventsManagement;
	
	public WebsiteSystem() {
		super();
	}

	public WebsiteSystem(AccountsManagement accountsManagement, EventsManagement eventsManagement, Shop shop) {
		super();
		this.accountsManagement = accountsManagement;
		this.eventsManagement = eventsManagement;
		this.shop = shop;
		AdminAccount admin = new AdminAccount("admin", "admin");
	    accountsManagement.addAccountToWebsite(admin);
	}

	public AccountsManagement getAccountsManagement() {
		return accountsManagement;
	}
	
	public void addAccountsManagement(AccountsManagement accountsManagement) {
		this.accountsManagement = accountsManagement;
	}
	
	public void addEventsManagement(EventsManagement eventsManagement) {
		this.eventsManagement = eventsManagement;
	}
	
	public Shop getShop() {
		return shop;
	}
	public EventsManagement getEventsManagement() {
		return eventsManagement;
	}

}
