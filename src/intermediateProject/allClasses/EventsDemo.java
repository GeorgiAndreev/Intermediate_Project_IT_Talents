package src.intermediateProject.allClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import src.intermediateProject.allExceptions.EventsException;

public class EventsDemo {

	public static void main(String[] args) {

		
		try {
			
			WebsiteSystem website = new WebsiteSystem();
			AccountsManagement accountsManagement = new AccountsManagement();
			EventsManagement eventsManagement = new EventsManagement();
			website.addAccountsManagement(accountsManagement);
			website.addEventsManagement(eventsManagement);
			
			LoggedUser user1 = new LoggedUser("opalqnka", website);
			LoggedUser user2 = new LoggedUser("parola", website);
			System.out.println(user1.getPassword());

			Event lekciqPoEkologi4noZemedelie1;
			
			lekciqPoEkologi4noZemedelie1 = user1.createEvent("lekciq po ekologi4no zemedelie",
					"kak da proizvejdame rasteniq za qdene ekologi4no", 30, 20, "single");
			MultidayEvent kursPoPletene1 = (MultidayEvent) user1.createEvent("kurs po pletene za maniqci",
					"qko 6te se plete tuka!", 15, 60f, "multiple");

			System.out.println(lekciqPoEkologi4noZemedelie1);
			System.out.println(kursPoPletene1);
			
			user2.signForEvent(lekciqPoEkologi4noZemedelie1.getName());
			
			eventsManagement.addEventToCenter(lekciqPoEkologi4noZemedelie1);
			
			user2.signForEvent(lekciqPoEkologi4noZemedelie1.getName());
			
			System.out.println(lekciqPoEkologi4noZemedelie1);

			System.out.println("\nDates testing");

			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy hh:mm");

			Date today = new Date();
			Date beginning = dateFormat1.parse("12/04/2016 3:21");
			Date ending = dateFormat1.parse("20/08/2016 12:59");
			System.out.println("beginning: " + dateFormat1.format(beginning));
			System.out.println("ending: " + dateFormat1.format(ending));
			System.out.println("today: " + dateFormat1.format(today));
			long dateCompare = beginning.compareTo(ending);
			if (dateCompare < 0) {
				System.out.println("beginning earlier than ending");
			}
			if (dateCompare > 0) {
				System.out.println("ending earlier than beginning");
			}
			if (dateCompare == 0) {
				System.out.println("ending equal to beginning");
			}

			dateCompare = ending.compareTo(today);
			if (dateCompare < 0) {
				System.out.println("date earlier than today");
			}
			if (dateCompare > 0) {
				System.out.println("date later than today");
			}
			if (dateCompare == 0) {
				System.out.println("date equal to today");
			}
			
			System.out.println("\nencryption test");
			
			    String password1 = "1234567";
				StringBuilder sb1 = new StringBuilder("Domat");
				StringBuilder sb2 = new StringBuilder(password1);
				StringBuilder sb3 = new StringBuilder("4u6ka");
				sb2.reverse();
				sb1.append(sb2);
				sb1.append(sb3);
				String encryptedPassword = sb1.toString();
				System.out.println(encryptedPassword);
			
			
				StringBuilder sb4 = new StringBuilder(encryptedPassword);
				sb4.reverse();
				String password2 = sb4.substring(5, encryptedPassword.length() - 5);
				System.out.println(password2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
