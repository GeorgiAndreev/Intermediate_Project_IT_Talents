package src.intermediateProject.allClasses;

public class AdminAccount extends LoggedUser {

	public AdminAccount(String firstName, String lastName, String username, String email, String address,
			String phoneNumber, String passWord) {
		super(firstName, lastName, username, email, address, phoneNumber, passWord);
	}

	public AdminAccount(String email, String passWord) {
		super(email, passWord);
	}

	public AdminAccount(String password, WebsiteSystem website) {
		super(password, website);
		// TODO Auto-generated constructor stub
	}

	public void removeAccount(LoggedUser account) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void viewEventsWaitingForApproval() {

	}

	public void approveEvent(long eventId) {

	}

	public void disapproveEvent(long eventId) {

	}

}
