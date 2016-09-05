package src.intermediateProject.allClasses;

public class ThisWebsite {
	
	public static AccountsManagement accountsManagement = new AccountsManagement();
	public static EventsManagement eventsManagement = new EventsManagement();
	public static Shop shop = new Shop();
	public static WebsiteSystem website = new WebsiteSystem(accountsManagement, eventsManagement, shop);
	
}
