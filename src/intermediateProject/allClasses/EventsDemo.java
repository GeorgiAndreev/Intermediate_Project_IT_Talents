package src.intermediateProject.allClasses;

public class EventsDemo {

	public static void main(String[] args) {
		
		LoggedAccount user1 = new LoggedAccount();
		
		Event lekciqPoEkologi4noZemedelie1 = user1.createEvent("lekciq po ekologi4no zemedelie", "kak da proizvejdame rasteniq za qdene ekologi4no", 30, 20,"single");
		MultidayEvent kursPoPletene1 = (MultidayEvent) user1.createEvent("kurs po pletene za maniqci", "qko 6te se plete tuka!", 15, 60f, "multiple");
		
		System.out.println(lekciqPoEkologi4noZemedelie1);
		System.out.println(kursPoPletene1);
		
		
	}

}
