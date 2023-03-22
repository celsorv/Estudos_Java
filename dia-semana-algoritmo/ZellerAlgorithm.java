import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class ZellerAlgorithm {

    public static int zellerAlgorithm(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;
        int h = (day + 13*(month+1)/5 + k + k/4 + j/4 + 5*j) % 7;

        return h;
    }


    public static void main(String[] args) {

        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a date (format dd/mm/yyyy): ");
        String dateString = scanner.nextLine();
        scanner.close();

        // Parse the day, month, and year from the input string
        int day = Integer.parseInt(dateString.substring(0, 2));
        int month = Integer.parseInt(dateString.substring(3, 5));
        int year = Integer.parseInt(dateString.substring(6));

        DayOfWeek dayOfWeekRef = LocalDate.of(year, month, day).getDayOfWeek();

        int dayOfWeek = zellerAlgorithm(year, month, day);
        System.out.printf("%02d/%02d/%04d => Java Time: %s, Zeller Algorithm: %s%n",
                day, month, year, dayOfWeekRef, daysOfWeek[dayOfWeek]);

    }


}
