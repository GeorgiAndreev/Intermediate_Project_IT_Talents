package src.intermediateProject.allClasses;

public abstract class User {

	private WebsiteSystem system;
	private LoggedUser amILoggedIn = null;
	
	public User(){
		
	}
	
	public User(WebsiteSystem system) {
		super();
		this.system = system;
	}

	public WebsiteSystem getSystem() {
		return system;
	}

	public LoggedUser getAmILoggedIn() {
		return amILoggedIn;
	}

	public void setAmILoggedIn(LoggedUser amILoggedIn) {
		this.amILoggedIn = amILoggedIn;
	}

}
