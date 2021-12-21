import java.util.Locale;
import java.util.Scanner;

public class WeekPlanning {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
  String[][] schedule = generateSchedule();
  boolean exit = false;
do {
  System.out.printf("Please, input the day of the week %n");
 String userInput = scanner.next();
 String formattedInput = userInput.toLowerCase().trim();

  switch (formattedInput) {
    case "monday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[0][0], schedule[0][1]);


    case "tuesday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[1][0], schedule[1][1]);


    case "wednesday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[2][0], schedule[2][1]);


    case "thursday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[3][0], schedule[3][1]);


    case "friday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[4][0], schedule[4][1]);


    case "saturday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[5][0], schedule[5][1]);


    case "sunday" ->
      System.out.printf("Your tasks for %s : %s%n", schedule[6][0], schedule[6][1]);


    case "exit" ->
      exit = true;


    default ->
      System.out.printf("Sorry, I don't understand you, please try again. %n");


  }
}
while(!exit);

  }
  public static String[][] generateSchedule () {
    String[][] schedule = new String[7][2];
    schedule[0][0] = "Monday";
    schedule[0][1] = "Do some homework";
    schedule[1][0] = "Tuesday";
    schedule[1][1] = "Workout";
    schedule[2][0] = "Wednesday";
    schedule[2][1] = "Take a walk";
    schedule[3][0] = "Thursday";
    schedule[3][1] = "Go to the cinema";
    schedule[4][0] = "Friday";
    schedule[4][1] = "Go to the club";
    schedule[5][0] = "Saturday";
    schedule[5][1] = "Go to the theatre";
    schedule[6][0] = "Sunday";
    schedule[6][1] = "Rest at home";
    return schedule;
  }
}
