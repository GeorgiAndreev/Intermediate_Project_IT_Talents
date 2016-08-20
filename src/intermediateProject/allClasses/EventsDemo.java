package src.intermediateProject.allClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import src.intermediateProject.allExceptions.EventsException;

public class EventsDemo {

	public static void main(String[] args) {

		
		try {
			
			LoggedAccount user1 = new LoggedAccount();

			Event lekciqPoEkologi4noZemedelie1;
			
			lekciqPoEkologi4noZemedelie1 = user1.createEvent("lekciq po ekologi4no zemedelie",
					"kak da proizvejdame rasteniq za qdene ekologi4no", 30, 20, "single");
			MultidayEvent kursPoPletene1 = (MultidayEvent) user1.createEvent("kurs po pletene za maniqci",
					"qko 6te se plete tuka!", 15, 60f, "multiple");

			System.out.println(lekciqPoEkologi4noZemedelie1);
			System.out.println(kursPoPletene1);

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
