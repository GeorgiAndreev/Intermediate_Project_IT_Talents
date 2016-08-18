package intermediateProject.allClasses;

public class EventsDemo {

	public static void main(String[] args) {
		
		LoggedAccount user1 = new LoggedAccount();
		Event kursPoPletene1 = user1.createEvent("kurs po pletene za maniaci", "qko 6te se plete tuka!", 15, 60f);
		System.out.println(kursPoPletene1);
	}

}
