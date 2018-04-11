package dateCalculator;

import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//The following Java console application calculates the period and duration between two dates.

public class PeriodBetweenDates {

	public static void main(String[] args) {
	
		Scanner scnr = new Scanner(System.in); 
		String firstUserInput = null;
		String secondUserInput = null;
		LocalDate firstUserDate = null;
		LocalDate secondUserDate = null;
		Period differenceBetweenDates;
		long differenceInDays;
		long differenceInHours;
		long differenceInMinutes;
		boolean isValidDate = true;
		
		System.out.println("Upon entering two dates, the program will determine the period between them (in years, months, and days). "
				+ "It will also calculate the duration (separately) in terms of total days, total hours, and total minutes.");

		//Request user input. Validate user input. Parse and format user input. Throw exception if user inputs anything other than a valid date.
		do {
			System.out.println("Please type the first date (format: yyyymmdd) and then press Enter.");
			try { 
				if (scnr.hasNextInt()){
					firstUserInput = scnr.next();
					firstUserDate = LocalDate.parse(firstUserInput, DateTimeFormatter.BASIC_ISO_DATE);
					isValidDate = true;
				}
				else {
					isValidDate = false;
					scnr.next();
					throw new DateTimeException(firstUserInput);
				}
			}
			catch (DateTimeException exc) {
				System.out.println("Please enter a valid date.");
			} 
		} while (!(isValidDate));
		
		do {
			System.out.println("Please type the second date (format: yyyymmdd) and then press Enter.");
			try {
				if (scnr.hasNextInt()) {
					secondUserInput = scnr.next();
					secondUserDate = LocalDate.parse(secondUserInput, DateTimeFormatter.BASIC_ISO_DATE);
					isValidDate = true;
				}
				else {
					isValidDate = false;
					scnr.next();
					throw new DateTimeException(secondUserInput);
				}
			}
			catch (DateTimeException exc) {
				System.out.println("Please enter a valid date.");
			} 
		} while (!(isValidDate));
		
		//Determine the period.
		differenceBetweenDates = Period.between(firstUserDate, secondUserDate);
		System.out.println("There are " + Math.abs(differenceBetweenDates.getYears()) + " years, " + Math.abs(differenceBetweenDates.getMonths()) 
			+ " months, and " + Math.abs(differenceBetweenDates.getDays()) + " days from the first date" + " to the second date.");
		
		//Determine the total number of days. 
		differenceInDays = ChronoUnit.DAYS.between(firstUserDate, secondUserDate);
		System.out.println(Math.abs(differenceInDays) + " total days");
		
		//Calculate the duration in hours.
		differenceInHours = differenceInDays * 24;
		System.out.println(Math.abs(differenceInHours) + " total hours");
		
		//Calculate the duration in minutes.
		differenceInMinutes = differenceInHours * 60;
		System.out.println(Math.abs(differenceInHours) + " total minutes");
		
	}

}
