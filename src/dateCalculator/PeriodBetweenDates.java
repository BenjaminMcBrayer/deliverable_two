package dateCalculator;

import org.jetbrains.annotations.NotNull;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Scanner;

/*
The following Java console application calculates the period and duration between two dates.
*/
public class PeriodBetweenDates {

	private static final Scanner SCNR = new Scanner(System.in);

	public static LocalDate validateUserDate(@NotNull Scanner scnr, String prompt) {
		LocalDate localDate = null;
		boolean isValid = false;
		while (!isValid) {
			String userInput = Validator.getString(scnr, prompt);
			if (userInput.length() == 8) {
				try {
					localDate = LocalDate.parse(userInput, DateTimeFormatter.BASIC_ISO_DATE);
					isValid = true;
				} catch (DateTimeException dateTimeException) {
					System.out.println("Please enter a valid date.");
				}
			} else {
				System.out.println("Please follow the instructions.");
			}
		}
		return localDate;
	}

	public static void main(String[] args) {
		System.out.println("Upon entering two dates, the program will determine the period between them (in years, " +
				"months, and days). ");
		System.out.println("It will also calculate the duration (separately) in terms of total days, total hours, " +
				"and total minutes.");

		/*
		 * Request, parse, format, and validate user input. Throw exception if user inputs anything other than a
		 * valid date.
		 */
		String prompt = "Please type the first date (format: yyyymmdd) and then press Enter.";
		LocalDate firstUserDate = validateUserDate(SCNR, prompt);
		prompt = "Please type the second date (format: yyyymmdd) and then press Enter.";
		LocalDate secondUserDate = validateUserDate(SCNR, prompt);
		
		//Determine the period.
		Period differenceBetweenDates = Period.between(Objects.requireNonNull(firstUserDate),
				Objects.requireNonNull(secondUserDate));
		System.out.printf("There are %d years, %d months, and %d days from the first date to the second date.%n",
				Math.abs(differenceBetweenDates.getYears()), Math.abs(differenceBetweenDates.getMonths()),
				Math.abs(differenceBetweenDates.getDays()));
		
		//Determine the total number of days. 
		long differenceInDays = ChronoUnit.DAYS.between(firstUserDate, secondUserDate);
		System.out.printf("%d total days%n", Math.abs(differenceInDays));
		
		//Calculate the duration in hours.
		long differenceInHours = differenceInDays * 24;
		System.out.printf("%d total hours%n", Math.abs(differenceInHours));
		
		//Calculate the duration in minutes.
		long differenceInMinutes = differenceInHours * 60;
		System.out.printf("%d total minutes%n", Math.abs(differenceInMinutes));
	}
}
